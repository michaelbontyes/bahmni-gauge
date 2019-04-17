Form Builder UI related tests
=====================



Created by bsantosh on 22/10/18

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Create a form by dragging controls
----------------
Tags: formBuilderIE

* Login and create the "formBuilderUITest" form by form builder
* Drag a "label" control to form
* Change the "Label" label name to "Iron Man"
* Drag a "Section" control to form
* Change the "Section" label name to "Captain America"
* Drag a "Obs" control to form
* Associate "HI, Penicillin" concept to "obs"
* Drag a "ObsGroup" control to form
* Associate "History and Examination" concept to "obsGroup"
* Click on save
* Verify "Section/Table is empty" showed up
* Drag a "obs" control to section
* Associate "HE, Date of consultation" concept to "obs"
* Click on save
* Verify "Form Saved Successfully" showed up
* Navigate to form list
* Enter version "1" of "formBuilderUITest" form details
* Verify canvas has "Iron Man" label
* Verify canvas has "HI, Penicillin" label
* Verify canvas has "History and Examination" label
* Click on publish
* Navigate to form list
* Enter version "1" of "formBuilderUITest" form details
* Click on Edit
* Confirm edit
* Validate that control "HI, Penicillin" is not editable
* Select "AddMore" property for "Captain America"
* Drag a "Label" control to form
* Delete "Label" control from form
* Click on save
* Click on publish

Create Table with table control
------------------------
Tags: formBuilderIE

* Login and create the "formBuilderTableTest" form by form builder
* Drag a "Table" control to form
* Validate that table control doesn't have any control properties
* Change the "Column1" label name to "left"
* Change the "Column2" label name to "right"
* Click on save
* Verify "Section/Table is empty" showed up
* Drag a obs control to "left" column of table
* Drag a obs control to "right" column of table
* Associate "HI, Penicillin" concept to "obs"
* Associate "FSTG, Date received" concept to "obs"
* Click on save
* Navigate to form list
* Enter version "1" of "formBuilderTableTest" form details
* Verify canvas has "left" label
* Verify canvas has "right" label
* Verify canvas has "HI, Penicillin" label
* Verify canvas has "FSTG, Date received" label
* Validate that addMore property is not available for "HI, Penicillin"
* Delete control "table" from form
* Confirm Delete

