Feature: Test Scenario1 (TS_002)  Vendor สร้างการนัดหมาย
  Register student on registration page

  
  @t
  Scenario: user navigates to the website and login
    Given user is on "http://localhost:3000" website
    Then login by user is "panarat.cha@dohome.co.th" and password is "Panarat01*"
    When user click on login button
    Then user is on homepage
    
    
    
 Scenario: Test Case1 (TC_1)Vendor สร้างการนัดหมาย
    When user click on create appointment button
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then user click save button

  Scenario: Test Case2 (TC_2)Vendor สร้างการนัดหมาย Don't add topic
    When user click on create appointment button
    Then user is on createappointment page
    Given user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณากรอกหัวข้อการนัดหมาย"
    
     Scenario: Test Case1 (TC_1)Vendor สร้างการนัดหมาย Add wrong data in date input (path)
    When user click on create appointment button
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "01/06/1991"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then user click save button
    
  Scenario: Test Case3 (TC_3)Vendor สร้างการนัดหมาย Don't add time
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณาเลือกช่วงเวลาที่ต้องการนัดหมาย"

  Scenario: Test Case4 (TC_4)Vendor สร้างการนัดหมาย Don't add detail
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณากรอกรายละเอียด"

  Scenario: Test Case5 (TC_5)Vendor สร้างการนัดหมาย Don't add type of product
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณาเลือกประเภทสินค้าที่จำหน่าย"

  Scenario: Test Caset6 (TC_6)Vendor สร้างการนัดหมาย Don't add type of dealer
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณาเลือกประเภทของผู้ค้า"

  Scenario: Test Case7 (TC_7)Vendor สร้างการนัดหมาย Don't add file
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณาเพิ่มไฟล์"

  Scenario: Test Case8 (TC_8)Vendor สร้างการนัดหมาย Don't add  file to upload
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user click accept on createappointment page
    When user click appointment button
    Then website has a pop up as "ไม่สามารถบันทึกได้, กรุณาเพิ่มไฟล์"

  Scenario: Test Case9 (TC_9)Vendor สร้างการนัดหมาย Don't click accept on createappointment page
    When user refresh
    Then user is on createappointment page
    Given user input topic as "อื่นๆ"
    And user input date as "15/12/2021"
    And user input time as "บ่าย"
    And user input detail as "test by automation test"
    And user input type of product as "ท่อPVC"
    And user input dealer as "ผู้ผลิต"
    And user add file by "\file_for_test\test1.jpg" path
    And user input file to upload is "เอกสาร Quotation"
    And user input file to upload is "เอกสาร Catalog "
    When user click appointment button
    Then website has a pop up as "กรุณายอมรับเงื่อนไขข้อตกลง"

 
  @t
  Scenario: Test Case10 (TC_10)Vendor สร้างการนัดหมาย Add wrong data in date input
    When user refresh
    Then user is on createappointment page
    And user input date as "Hello"
    Then website has a pop up under date input as "Value must be a date or time"

 
  @t
  Scenario: Test Case10 (TC_10)Vendor สร้างการนัดหมาย Add wrong data in date input
    When user refresh
    Then user is on createappointment page
    And user input date as "333/12/22222"
    Then website has a pop up under date input as "Value must be a date or time"
    
  