.. _translation:

Translating GeoServer
=====================

We would like GeoServer available in as many languages as possible, so we want your help to add localizations / translations, specifically the GeoServer UI and documentation.

Translating the UI
------------------

The GeoServer UI stores text strings inside properties files. The default (English) files are named :file:`GeoServerApplication.properties` and are located in the following directories within a modul::

  src/main/resources/

To translate the GeoServer UI to another language, copy and rename each of these files to be :file:`GeoServerApplication_[LANG].properties` where [LANG] is the language code as defined in `RFC 3066 <http://www.ietf.org/rfc/rfc3066.txt>`_  For example, the language code for German is ``de`` and for Brazilian Portuguese is ``pt-BR``.

Once created, each line in the files represents a string that will need to be translated. If you like to keep origin value from English source file its recommended to avoid duplication of such key-value pairs and remove it from translated property file, e.g.::

  url = URL

Such values are taken from origin property file in UI. If finished, you will need to commit these files or submit a JIRA issue with attached patch. See the section on :ref:`source` for more information on how to commit.

Editing in Eclipse
~~~~~~~~~~~~~~~~~~

If you are using `Eclipse <http://www.eclipse.org/>`_, you can install the `Eclipse ResourceBundle Editor <http://sourceforge.net/projects/eclipse-rbe/>`_.  Once installed, you can edit the :file:`src/main/resources/GeoServerApplication.properties` files in all ``web-*`` projects (``web-core``, ``web-demo``, etc.) with the ResourceBundle editor.

Editing in Transifex
~~~~~~~~~~~~~~~~~~~~

In 2011 few people from User community created a project at `Transifex <https://www.transifex.com/GeoServer/>`_. Tranisfex is a translation platform to manage resources, languages, and teams. In addition it provides a Translation Memory to share phrases over all projects. In addition, it reduces complexity (e.g. working with git, setup IDE, etc) for Users to get UI translated.

  .. figure:: images/Transifex_languages.png
    :width: 600px

For more details about Transifex, how it works and how to get started please consult `Transifex Help <http://docs.transifex.com/>`_.

Currently the project is synchcronized with Github Repository one way, from Github to Transifex whenever an origin resource file has been changed. If so, Translation teams get messages to update their languages.

Initially all exiting `GeoServerApplication.properties` from 

 * web-modules
 * extensions and
 * community 

were created as resources to translate.

Its required to create an account or login with your prefered Social Account. At the moment of writing, its possible to create one at Transifex or use an existing Social account.

  .. figure:: images/Transifex_login.png
    :width: 250px

Its quite easy to join a team as Translator, Reviewer or even to request a new Language to setup. Its required to accept a :doc:`Contributors License Agreement (CLA) <policies/committing>` to translate GeoServer UI.

After navigating to the resource an editor view is displayed to start translating

  .. figure:: images/Transifex_Editor.png
    :width: 640px

Synchronize from Transifex back into codebase
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

As an committer of GeoServer project you can easyly download resources into your working copy and use git to commit and push back to GeoServer github Repository. Please note that at Transifex are two different projects to work with 

 * geoserver (for github master branch)
 * geoserver_stable (for the current stable branch, e.g. 14.x)

Before committing the changes make sure the branch you checked out locally matches to the project and its files from Transifex.

Translating documentation
-------------------------

The GeoServer User Manual contains a wealth of information from the novice to the experienced GeoServer user.  It is written using the `Sphinx Documentation Generator <http://sphinx.pocoo.org/>`_.  The stable branch version of the User Manual exists as the following URL:

  http://docs.geoserver.org/stable/en/user/

Built from the following source files:

  /doc/en/user/

To create a User Manual in a different language, first create a directory called :file:`/doc/[LANG]/`, where [LANG] is the language code as defined in `RFC 3066 <http://www.ietf.org/rfc/rfc3066.txt>`_.  The you can copy the contents of :file:`/doc/en/user/` to :file:`/doc/[LANG]/user` and edit accordingly, or generate a new Sphinx project in :file:`/doc/[LANG]/user`.   (See the `Sphinx Quickstart <http://sphinx.pocoo.org/tutorial.html>` for more information about creating a new project.)

The GeoServer Sphinx theme exists at :file:`/doc/en/user/themes`, so that can be copied (and modified if desired) to :file:`/doc/[LANG]/user/themes`.

When finished, you will need to commit the content (if you have commit rights) or submit a JIRA issue with attached patch.  See the section on :ref:`source` for more information on how to commit.  Setting up the documentation to be hosted on docs.geoserver.org will require a project administrator; please send an email to the mailing list for more details.

Tips
~~~~

* See the `GeoServer Documentation Manual <http://docs.geoserver.org/latest/en/docguide/>`_ for more information about writing documentation.
* The Developer Manual exists at :file:`/doc/en/developer`.  The same procedures for editing the User Manual apply to the Developer Manual.










