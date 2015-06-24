package com.uspeclipse.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.uspeclipse.testscripts.person.AddNewPerson_TestCaseID2583;
import com.uspeclipse.testscripts.person.AddPersonAddress_TestCaseID2943;
import com.uspeclipse.testscripts.person.AddPersonAddress_TestcaseID2944;
import com.uspeclipse.testscripts.person.AddPersonContact_TestCaseID2889;
import com.uspeclipse.testscripts.person.AddPersonReference_TestCaseID2981;
import com.uspeclipse.testscripts.person.AddReferenceNumber_TestCaseID2808;
import com.uspeclipse.testscripts.person.AddWarning_TestCaseID2983;
import com.uspeclipse.testscripts.person.EditPersonContactDetails_TestCaseID2891;
import com.uspeclipse.testscripts.person.EditPersonRecord_TestCaseID2785;
import com.uspeclipse.testscripts.person.EditReferenceNumbers_TestCaseID2972;
import com.uspeclipse.testscripts.person.EditWarningPerson_TestCaseID2940;
import com.uspeclipse.testscripts.person.EndPersonAddress_TestcaseID2969;
import com.uspeclipse.testscripts.person.FindPerson_TestCaseID2650;
import com.uspeclipse.testscripts.person.HomePage_TestCaseID2986;
import com.uspeclipse.testscripts.person.PersonAddressDisplay_TestCaseID3083;
import com.uspeclipse.testscripts.person.RemoveContactDetails_TestCaseID2892;
import com.uspeclipse.testscripts.person.RemovePersonAddress_TestCaseID2965;
import com.uspeclipse.testscripts.person.RemoveReferenceNumber_TestCaseID2888;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	AddNewPerson_TestCaseID2583.class, 	 						//-- Working
	AddPersonAddress_TestCaseID2943.class  	,					//-- working
	AddPersonAddress_TestcaseID2944.class  	,					//-- Tentative - Not sure
	AddPersonContact_TestCaseID2889.class,	 					//-- Working
	AddPersonReference_TestCaseID2981.class  	,				//-- Working
	AddReferenceNumber_TestCaseID2808.class,  					//-- working    
	AddWarning_TestCaseID2983.class	,							//-- Working
	EditPersonContactDetails_TestCaseID2891.class  , 			//-- Working
	EditPersonRecord_TestCaseID2785.class	,					//-- Working
	EditReferenceNumbers_TestCaseID2972.class	,				//-- Working
	EditWarningPerson_TestCaseID2940.class	,					//-- Working
	EndPersonAddress_TestcaseID2969.class		,				//-- Working
	FindPerson_TestCaseID2650.class,							//-- Working
	HomePage_TestCaseID2986.class	,							//-- Working
	RemoveContactDetails_TestCaseID2892.class	,				//-- Working
//	RemovePersonAddress_TestCaseID2965.class		//-- Not working
	RemoveReferenceNumber_TestCaseID2888.class	,				//-- Working
	PersonAddressDisplay_TestCaseID3083.class					//-- Working
	})
public class JunitTestSuite {
}
