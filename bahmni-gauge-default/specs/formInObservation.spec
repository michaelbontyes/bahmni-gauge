Add New Obs Form In Observation
===============================

Enter the add new obs form dialog in observation page
-----------------------------------------------------

tags: regression, sanity

* Create a new patient through API
* Open visit of type "OPD" in "BAHMNI_GAUGE_APP_LOCATION" location for previous patient using api
* Create a "11xueying31" form using "obs"
* Login to app and navigate to "Clinical" app
* Select existing patient from patient listing page under tab "Active"
* Navigate to consultation
* Click on add new obs form
* search "11xueying31" obs form
* Choose "11xueying31" obs form
* Enter "11" into control
* Save the consultation
* Navigate to dashboard
* Click on implementer interface app
* Click on form builder app
* Enter version "1" of "11xueying31" form details
* Click on Edit
* Confirm edit
* Save "11xueying31" form using "obs_obsGroup" by API
