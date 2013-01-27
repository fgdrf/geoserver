/* Copyright (c) 2001 - 2013 OpenPlans - www.openplans.org. All rights reserved.
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.web.wicket;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;
import org.geotools.referencing.CRS;
import org.geotools.util.logging.Logging;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * A model allowing to edit an SRS property with the CRSPanel (by dynamically
 * converting it into a {@link CoordinateReferenceSystem} and back)
 */
@SuppressWarnings("serial")
public class SRSToCRSModel implements IModel {
    private static final Logger LOGGER = Logging.getLogger(SRSToCRSModel.class);
    IModel srsModel;
    
    /** the model to access the value from resource file **/
    private StringResourceModel unknownCRSi18n;
    
    public SRSToCRSModel(IModel srsModel) {
        this.srsModel = srsModel;
        unknownCRSi18n = new StringResourceModel("unknownCRS", this.srsModel, "UNKNOWN");
    }

    public Object getObject() {
        String srs = (String) srsModel.getObject();
        if(srs == null || unknownCRSi18n.getString().equals(srs))
            return null;
        try {
            return CRS.decode(srs);
        } catch(Exception e) {
            return null;
        }
    }

    public void setObject(Object object) {
        CoordinateReferenceSystem crs = (CoordinateReferenceSystem) object;
        try {
            Integer epsgCode = CRS.lookupEpsgCode(crs, false);
            String srs = epsgCode != null ? "EPSG:" + epsgCode : null;
            srsModel.setObject(srs);
        } catch(Exception e) {
            LOGGER.log(Level.INFO, "Failed to lookup the SRS code for " + crs);
            srsModel.setObject(null);
        }
        
    }

    public void detach() {
        srsModel.detach();
    }
    
}
