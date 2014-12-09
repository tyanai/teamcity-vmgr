teamcity-vmgr
=============

Adds an ability to launch a session or call Cadence vManager vAPI REST API dynamically as a step in your build.

This plugin adds an ability to perform REST over HTTP calls to Cadence vManager as a step in your build.

Why this plugin ?
=================
Cadence vManager (starting version 14.1 and above) is now exposing a REST API (vAPI) for performing automation queries and updates for its regression/test and coverage data.  This plugin enables you to add a remote execution for extracting runs information, reports data or even launching new sessions as part of your build process.

Features
========
- [x] Free-style job plugin (can perform all vManager API call).
- [x] Support static/dynamic API calls
- [x] Support dynamic authentication per user id.
- [x] Special build step for performing launch of vsif files dynamically.

Limitations
===========
The plugin support for remote launcing of vsif will be supported for Incisive 14.1 S5 and above.
