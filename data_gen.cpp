#include <bits/stdc++.h>
using namespace std;

vector <string> id = {"2020A7PS0001P","2020A7PS0002P","2020A7PS0003P","2020A7PS0004P","2020A7PS0005P","2020A7PS0006P","2020A7PS0007P","2020A7PS0010P","2020A7PS0012P","2020A7PS0013P","2020A7PS0014P","2020A7PS0016P","2020A7PS0017P","2020A7PS0020P","2020A7PS0021P","2020A7PS0024P","2020A7PS0025P","2020A7PS0026P","2020A7PS0032P","2020A7PS0033P","2020A7PS0035P","2020A7PS0036P","2020A7PS0037P","2020A7PS0040P","2020A7PS0043P","2020A7PS0045P","2020A7PS0048P","2020A7PS0049P","2020A7PS0050P","2020A7PS0054P","2020A7PS0057P","2020A7PS0059P","2020A7PS0060P","2020A7PS0064P","2020A7PS0065P","2020A7PS0066P","2020A7PS0067P","2020A7PS0069P","2020A7PS0071P","2020A7PS0072P","2020A7PS0073P","2020A7PS0075P","2020A7PS0077P","2020A7PS0081P","2020A7PS0082P","2020A7PS0083P","2020A7PS0084P","2020A7PS0087P","2020A7PS0088P","2020A7PS0089P","2020A7PS0090P","2020A7PS0092P","2020A7PS0093P","2020A7PS0094P","2020A7PS0095P","2020A7PS0096P","2020A7PS0098P","2020A7PS0100P","2020A7PS0101P","2020A7PS0102P","2020A7PS0104P","2020A7PS0105P","2020A7PS0106P","2020A7PS0107P","2020A7PS0108P","2020A7PS0110P","2020A7PS0111P","2020A7PS0112P","2020A7PS0113P","2020A7PS0114P","2020A7PS0116P","2020A7PS0119P","2020A7PS0120P","2020A7PS0121P","2020A7PS0123P","2020A7PS0124P","2020A7PS0128P","2020A7PS0129P","2020A7PS0131P","2020A7PS0133P","2020A7PS0134P","2020A7PS0139P","2020A7PS0140P","2020A7PS0144P","2020A7PS0145P","2020A7PS0146P","2020A7PS0148P","2020A7PS0297P","2020A7PS0299P","2020A7PS0309P","2020A7PS0310P","2020A7PS0311P","2020A7PS0313P","2020A7PS0315P","2020A7PS0970P","2020A7PS0971P","2020A7PS0972P","2020A7PS0973P","2020A7PS0974P","2020A7PS0975P","2020A7PS0979P","2020A7PS0980P","2020A7PS0981P","2020A7PS0983P","2020A7PS0984P","2020A7PS0986P","2020A7PS0987P","2020A7PS0988P","2020A7PS0991P","2020A7PS0993P","2020A7PS0994P","2020A7PS0995P","2020A7PS1201P","2020A7PS1202P","2020A7PS1205P","2020A7PS1206P","2020A7PS1207P","2020A7PS1208P","2020A7PS1209P","2020A7PS1210P","2020A7PS1211P","2020A7PS1212P","2020A7PS1214P","2020A7PS1507P","2020A7PS1509P","2020A7PS1510P","2020A7PS1511P","2020A7PS1512P","2020A7PS1513P","2020A7PS1515P","2020A7PS1675P","2020A7PS1677P","2020A7PS1678P","2020A7PS1679P","2020A7PS1680P","2020A7PS1681P","2020A7PS1683P","2020A7PS1684P","2020A7PS1686P","2020A7PS1687P","2020A7PS1688P","2020A7PS1689P","2020A7PS1690P","2020A7PS1691P","2020A7PS1692P","2020A7PS2051P","2020A8PS0456P","2020A8PS0533P","2020A8PS0537P","2020A8PS0542P","2020A8PS0547P","2020A8PS0549P","2020A8PS0552P","2020A8PS0554P","2020A8PS0570P","2020A8PS0572P","2020A8PS0573P","2020A8PS0582P","2020A8PS0782P","2020A8PS0804P","2020A8PS0807P","2020A8PS0818P","2020A8PS0819P","2020A8PS0832P","2020A8PS0901P","2020A8PS1043P","2020A8PS1541P","2020A8PS1549P","2020A8PS1553P","2020A8PS1556P","2020A8PS1558P","2020A8PS1562P","2020A8PS1790P","2020A8PS1791P","2020A8PS1792P","2020A8PS1793P","2020A8PS1794P","2020A8PS1795P","2020A8PS1796P","2020A8PS1798P","2020A8PS1799P","2020A8PS1800P","2020A8PS1801P","2020A8PS1802P","2020A8PS1803P","2020A8PS1804P","2020A8PS1805P","2020A8PS1806P","2020A8PS1807P","2020A8PS1808P","2020A8PS1809P","2020A8PS1810P","2020A8PS1812P","2020A8PS1813P","2020A8PS1814P","2020A8PS1816P","2020A8PS1817P","2020A8PS1818P","2020A8PS1819P","2020A8PS1820P","2020A8PS1821P","2020A8PS1822P","2020A8PS1825P","2020A8PS1826P","2020A8PS1828P","2020A8PS1829P","2020ABPS0489P","2020ABPS0635P","2020ABPS0640P","2020ABPS1048P","2020ABPS1051P","2020ABPS1065P","2020ABPS1067P","2020ABPS1575P","2020ABPS1577P","2020ABPS1830P","2020ABPS1831P","2020ABPS1832P","2020ABPS1833P","2020ABPS1834P","2020ABPS1837P","2020ABPS1838P","2020ABPS1840P","2020ABPS1841P","2020ABPS1843P","2020ABPS1844P","2020ABPS1845P","2020ABPS1846P","2020ABPS1847P","2020ABPS1848P","2020ABPS1849P","2020ABPS1850P","2020ABPS1851P","2020ABPS1852P","2020ABPS1853P","2020ABPS1854P","2020ABPS1856P","2020ABPS1857P","2020ABPS1858P","2020ABPS1861P","2020B1A10615P","2020B1A10617P","2020B1A10641P","2020B1A10662P","2020B1A11226P","2020B1A11385P","2020B1A11609P","2020B1A11888P","2020B1A11897P","2020B1A11898P","2020B1A11899P","2020B1A11906P","2020B1A20658P","2020B1A21613P","2020B1A30602P","2020B1A30660P","2020B1A31231P","2020B1A31392P","2020B1A31610P","2020B1A31904P","2020B1A31910P","2020B1A40593P","2020B1A40601P","2020B1A40616P","2020B1A40621P","2020B1A40651P","2020B1A40652P","2020B1A40656P","2020B1A41396P","2020B1A41607P","2020B1A41889P","2020B1A41909P","2020B1A41912P","2020B1A41913P","2020B1A70603P","2020B1A70611P","2020B1A70623P","2020B1A70630P","2020B1A70648P","2020B1A71380P","2020B1A71602P","2020B1A71605P","2020B1A71612P","2020B1A71896P","2020B1A71902P","2020B1A71942P","2020B1A80609P","2020B1A80668P","2020B1A81914P","2020B1AA1379P","2020B1AA1890P","2020B1AB0669P","2020B1AB0671P","2020B1AB1141P","2020B1AB1377P","2020B1AB1381P","2020B1AB1386P","2020B1AB1893P","2020B1AB1901P","2020B1AB1903P","2020B1AB1905P","2020B1AB1908P","2020B1AB1915P","2020B1AB1916P","2020B1TS1252P","2020B1TS1287P","2020B2A10647P","2020B2A10649P","2020B2A11617P","2020B2A11918P","2020B2A11928P","2020B2A11941P","2020B2A11944P","2020B2A11950P","2020B2A11951P","2020B2A20745P","2020B2A21145P","2020B2A21636P","2020B2A21920P","2020B2A21923P","2020B2A21925P","2020B2A21940P","2020B2A30637P","2020B2A30654P","2020B2A30704P","2020B2A31619P","2020B2A31623P","2020B2A31921P","2020B2A31922P","2020B2A31927P","2020B2A31954P","2020B2A40703P","2020B2A40711P","2020B2A40733P","2020B2A41401P","2020B2A41412P","2020B2A41926P","2020B2A41931P","2020B2A41943P","2020B2A41947P","2020B2A41949P","2020B2A41952P","2020B2A41955P","2020B2A70633P","2020B2A70687P","2020B2A70709P","2020B2A70731P","2020B2A71136P","2020B2A71406P","2020B2A71611P","2020B2A71932P","2020B2A71945P","2020B2A81413P","2020B2A81624P","2020B2A81635P","2020B2A81924P","2020B2A81929P","2020B2A81938P","2020B2A81948P","2020B2AA0722P","2020B2AA1146P","2020B2AA1403P","2020B2AA1946P","2020B2AB1917P","2020B2TS1254P","2020B2TS1283P","2020B2TS1286P","2020B2TS1300P","2020B4A10690P","2020B4A11469P","2020B4A11655P","2020B4A11983P","2020B4A20737P","2020B4A20881P","2020B4A21973P","2020B4A21980P","2020B4A21981P","2020B4A21993P","2020B4A30694P","2020B4A30726P","2020B4A30853P","2020B4A30876P","2020B4A31235P","2020B4A31448P","2020B4A31476P","2020B4A31647P","2020B4A31649P","2020B4A31650P","2020B4A31977P","2020B4A31979P","2020B4A31987P","2020B4A31995P","2020B4A40683P","2020B4A40710P","2020B4A40735P","2020B4A40954P","2020B4A41446P","2020B4A41974P","2020B4A41978P","2020B4A41988P","2020B4A41990P","2020B4A70600P","2020B4A70632P","2020B4A70830P","2020B4A70833P","2020B4A70834P","2020B4A70836P","2020B4A70844P","2020B4A70859P","2020B4A70878P","2020B4A70948P","2020B4A70969P","2020B4A71325P","2020B4A71654P","2020B4A71975P","2020B4A71976P","2020B4A71986P","2020B4A80824P","2020B4A81440P","2020B4A81658P","2020B4A81984P","2020B4A81989P","2020B4A81994P","2020B4A81996P","2020B4AA0474P","2020B4AA0607P","2020B4AA1331P","2020B4AA1982P","2020B4AA1991P","2020B4PS1453P","2020B4TS1258P","2020B4TS1261P","2020B4TS1273P","2020B4TS1274P","2020B4TS1276P","2020B4TS1278P","2020B5A10678P","2020B5A10688P","2020B5A10921P","2020B5A11459P","2020B5A11665P","2020B5A11673P","2020B5A12002P","2020B5A20614P","2020B5A20718P","2020B5A21462P","2020B5A21485P","2020B5A21659P","2020B5A21666P","2020B5A21999P","2020B5A30926P","2020B5A30929P","2020B5A30932P","2020B5A30945P","2020B5A31662P","2020B5A32008P","2020B5A40627P","2020B5A40628P","2020B5A40744P","2020B5A40960P","2020B5A40967P","2020B5A41336P","2020B5A41454P","2020B5A41457P","2020B5A41458P","2020B5A41664P","2020B5A41671P","2020B5A41672P","2020B5A42010P","2020B5A42012P","2020B5A70604P","2020B5A70693P","2020B5A70788P","2020B5A70897P","2020B5A70912P","2020B5A70924P","2020B5A70930P","2020B5A70931P","2020B5A70951P","2020B5A72001P","2020B5A72006P","2020B5A80925P","2020B5A80966P","2020B5A81399P","2020B5A82052P","2020B5AA0698P","2020B5AA0719P","2020B5AA0740P","2020B5AA0910P","2020B5AA0915P","2020B5AA0947P","2020B5AA1398P","2020B5AA1471P","2020B5AA2007P","2020B5AB0900P","2020B5AB2004P","2020B5AB2005P","2020B5PS0905P","2020B5PS1998P","2020B5TS1251P"};

vector <string> name = {"AISHWARYA SAM","YUGAL JOSHI","ANUSHKA BHATTACHARJEE","N SANSHRAY","PUTTAPAKA SHASHANK","SAMINENI ADITHYA PRAKASH CHOWDA","GURLE VAISHNAVI","KABRA SANCHIT MANISH","IYER CHAITANYA RAJESH","KAUSTAB CHOUDHURY","TIKESH VAISHNAV","RUCHIKA SARKAR","URVASHI SHARMA","YATIN SINGLA","SAMRIDDHA SINHA","KOTALWAR NACHIKET DNYANESHWAR","MOHAMMED SHAZ FURNITUREWALA","PATEL PARTH JEETENDRA","YELAKANTI AKHIL DEV","AGRAWAL RACHIT MOHIT","SHREEKAR PURANIK","AARYA ATTREY","ABHAY NARENDRAN","SWAPNIL SHIVAM","PARTHA SARATHI PURKAYASTHA","LABEEB AHSAN","MOHIT DILIP MAKWANA","MADHAV MADHUSOODANAN","DHANUSH SOMA","KARTIK KUMAR PAWAR","HARSHIT TEJAS MEHTA","VEDANTKUMAR THAKKAR","SARTHAK ARORA","ADIT KALBALIA","AYUSH SINGH BHANDARI","ARNAV PRANAY GUJARATHI","NIVEDITHA KOVILAKATH","PANKAJ PANJWANI","SUKRITI","ARCHAJ JAIN","SHASHANK AGRAWAL","SHREYAS KETKAR","SURI SAI VISWANADHA ADITYA","ROHAN SRINIVASAN","ARNAV TRIPATHI","SHAH  JAYSHEEL  DIPALBHAI","TANVEER SINGH","ADITYA KANTHI","PARTH NILESH THAKKAR","SAMYAK JAIN","AYUSH MADAN","SARTHAK SHAH","SARVESH GUPTA","ARYA VEER SINGH CHAUHAN","SAFDAR FAISAL","AKSHAT GUPTA","SIDDHARTH KHANDELWAL","JATIN NEHLANI","NISCHAY KHANDELWAL","HARDIK JAIN","SAMYAK BAKLIWAL","AMIT GUPTA","MADHAV GUPTA","ATISH","RISHI RAKESH SHRIVASTAVA","HARSH PRIYADARSHI","ANSHIKA GUPTA","SARTHAK AGARWAL","DEVASHISH SIWATCH","BIRLA PRATHAM SANDEEP","ANSH GUPTA","RANIPA JASH RAMNIKLAL","KSHITIJ GARG","VISHWA TAPAN SHAH","ARYAN HEMANTKUMAR DESAI","SHIVAM ABHAY PANDE","PRANAV GUPTA","ANISH SUBHASH GHULE","SHIRISH KUMARAVEL","MRIDUL CHANDAK","SHADAN HUSSAIN","AMEYA DESHMUKH","SAHIL SHAH","VARUN SAHNI","GAURAV ANAND KUMAR","TOSHIT JAIN","DEEP PANDYA","SARANG SRIDHAR","GANDHI SAMAY AMIT","RISHABH PARMAR","BHAVYA RAJESH KALYANI","KARMANYA KHANNA","HRISHIKESH HARSH","VANSH GUPTA","DEBJIT KAR","DEEPAM PRIYESH DESAI","KSHITIJ TANDON","MEET PATEL","KUSHAGRA SAHNI","ANISH ATUL KULKARNI","RAMAKANT PANDURANG TALANKAR","MITHIL SHAH","UTKARSH","CHIRAG MAHESHWARI","UTSAV GOEL","NIDHISH  JOGEN  PAREKH","SARTHAK TAYAL","PATEL VRAJ TRUSHAR","OMKAR SACHIN GOTHANKAR","SATVIK SINHA","AKSHAT AGRAWAL","KASHISH MAHAJAN","RISHEET AGARWAL MEHTA","PRANEET KARNA","NIKHIL AMARISH PRADHAN","SHAMIKA MITTAL","SANJANA PADAVALA","SURAJ PHANINDRA","SRIRAM RAMANATHAN","ARVIND RAM","RISHABH KUMAR","GOKUL SANJEEVA REDDY","DARSHAN ABHAY KUMAR","SHAILESH KUMAR SINGH","SHASHANK KHATTAR","MITUL CHADHA","ADITYA SHETH","SOUMYA VISHNOI","P V S TARAK SHREE VALLABHA","ARJAV JAIN","BHANUPRATAP RATHORE","RISHABH BARNWAL","PULKIT SINHA","PRATHAM OZA","DHRUV GUPTA","SHIVAM MISHRA","ARYA ABHAYA KULKARNI","SHREYAS SESHAM","ATHARWA PANDEY","KHUSHI SHAH","HEMESH GUPTA","ARYAN KAPOOR","HARY AHUJA","ANTRIKSH SHARMA","ARYAN PRASAD CHAVAN","ANISH GUPTA","KUHOO GOYAL","JOGIREDDY YASWANTH REDDY","ARYAMAN SINGH","TANUJ LAHOTI","DAKSH JUNEJA","ZEHAAN SHARMA","NAVDEEP SORLAN","AYUSH RANJAN","DEVESH MITTAL","AARYAN ABHAY BAHUGUNE","ABHINAV CHOUDHARY","MAHIP KHANDELWAL","YAMANDEEP SINGH","PRITISH SURESH DAKHOLE","KENIYA JINAY KIRAN","HARSHIT JODHANI","ANIMESH SINGH","DIVYAM GOEL","U JANVI","RISHI HEMANT SHAH","POOJAN NIKHIL GANDHI","ANIKET PANDEY","MUDIT RAWAT","ARYA D","KAUSTUBH MISHRA","SANSKAR KAUSHIK","AKSHAT AWASTHI","AARSH KHARE","VASHU","SNIGDHA GUPTA","HARSH PANT","ARSH MOHAN","ABHINAV HARSHA ADYA","ROHAN ANIL MUSKAWAD","ATHARVA UDAY DESHMUKH","GAURANG RATHI","PRATIK MOHAN","ISHAN KULKARNI","NIKITA TAWANI","ANANYA SINGH","PRABHSIMRAN SINGH","ROHIT JOHN MATHEW","SHREYA KHUBBER","CHIRAG AGARWAL","SAINIKHIL RAMPRASAD KANCHUMART","APOORV RASTOGI","SINDURA PATRIA","SARVESH KARTHIC","ATISHAY JAIN","KHUSHAAL CHABA","TARUN VASHISHTHA","RISHAV RAJ","LALIT ADITHYA P","PATEL RUDRESH KETANBHAI","SARTHAK GUPTA","RAJARSHI MISRA","MANN JAGDISH SHAH","ARYAN SINGH","SANKALP DAVE","VISHNU BANSAL","KESHAV BANSAL","ADARSH GOEL","JATIN KUMAR SAXENA","RAHUL CHORARIA","VEDANG CHOUDHARY","VEDIKA GUPTA","FAHAD QURESHI","PRATINAV MONGIA","SHASHWAT ASATI","SHAURYA BANSAL","VIBHAV AGRAWAL","SNEHA SANJIV PATIL","DHRUV JAJOO","YASH AGARWAL","B.ARVIND","SAHIL SNEHAL SHAH","VAIBHAVA SINGH","JIWESH GARG","HARRIS FAROOQ ASHAI","SANKET PATTNAIK","SHEREEN GAUBA","CHAITANYA BALANI","PRADYUNN HORA","UTKARSH SINGHVI","DENVER JOHN LOBO","ATHARV SRIVASTAVA","AMISH MEHTA","ISHITA MUNSHI","SAMKIT JAIN","PATIL PARTH SHRIKANT","GAIRIK MUKHERJEE","PRIYANSH GARG","LAKSHYA JAIN","AKSHAT KOTHARI","AMARTYA KUMAR","MANAS MANMOHAN KALYANPAD","ANANT JAIN","ADITYA MISHRA","NIKHIL GIRISH RATNAPARKHI","HARSH SRIVASTAVA","BHAVUK","ISHITTA TARUN SARDA","JAIN TANISHQ HASMUKHBHAI","NANDAN GOUD B","SURYANK AGARWAL","SHREYASH SINGH","SIDDHARDH MALLISETTI","VAIBHAV SINGLA","KARANDE ASHIRWAD ABHIMAN","SURAMYA","ANIKA CHHABRA","SIDDHARTH SINGH SENGAR","ROHAN SHARDA","SAHAJ TANDI","SANYAM GUPTA","SHIVAM ARYA","HARSH KHANDELWAL","ANANYA SARASWAT","SIDDHANT ATRISH","ISHPREET SINGH SOOD","SHUBHAM MISHRA","SHIKHAR SRIVASTAVA","ANMOL GANDHI","VIDUSHI SINHA","ARYAN SHARMA","SUMAIRSINGH NARSINGH BAIS","NIKUNJ SINGHAL","AMEYA AGLAWE","SHRIPURNA GANGOPADHYAY","SUBHRAMIT BASU BHOWMICK","AYUSH","ADITYA THAKUR","TANUSHI GARG","ARCHI JAIN","SALONI BHANDARI","SAMARTH TRIVEDI","HARSHIL SETHI","KARMAN SINGH SETHI","AVYAKT GARG","DEVANGI SHARMA","JAIN VINEET","RITWIK SINGH","ABHISHEK SATPATHY","PRAJWAL NAKIL","MADHAV GARG","KINSHUK RASTOGI","YASH AGARWAL","KESHAV KALIA","YASHVARDHAN GOEL","SUSHANT PRIYAM","AARYAMAN SAHOO","SINGHANIA JEET","PRIYANKA SATHEESAN NAMBOODRI","TANMAY JAIN","UDBHAV CHOUDHARY","HRITIK KUMAR","AYAAN FEROZ KHAN","ASHISH VERMA","KUCHIBHOTLA ANANYA KIRTHI","RITIKA KANWAR","AVNEET SINGH","NAVNEET SINGH","RIDHIM JAIN","LAKSHIT JAIN","NAMAN JALAN","RAMESTHA PRINCE","ANUBHAV SABHARWAL","KARAN MEHTA","P SAI NANDA HARSHA","HARSHIT BADHWAR","SYED AGA HANI RIZA","JUMDE YASH UDAY","PRANJAL RAJESH DEVENE","DEEPENDER","RAGHAV KHUGSHAL","RITIK YADAV","RAASHI VANWANI","KANIKA GARG","PAURAS SUNIL PATIL","PRATHAM GUPTA","HARSHVARDHAN JOUHARY","AKARSH SAXENA","SUKHANROOP KAUR BRAR","LAVYA DHAWAN","SATHYA SKANDA B M","ACHYUTHA YESWANTH SRIRAJ","AKSHAT DASHOTAR","SHASHWAT SHARMA","DHRUV BANSAL","BHAVAY GOENKA","PRASHANT R GUPTA","AYUSH KUMAR","VIVEK KALLANI","SHIVANG RAI","RAJEEV KUMAR","NISHANT","SIDDHARTH JAIN","ANMOL","SIDARTHA SANKARA PATI","KOMMULA SAI VENKATA DHANUSH","S SHAIPRANESH","SUHANI MODI","SIRIPURAM SURYA","NIKHIL AGARWAL","PULKIT","TARESH BANSAL","NIKHIL SHARMA","ANSH GUPTA","DEVAYUSH SHUKLA","MANAN DHADDA","ARKADEEP CHOWDHURY","GARIMA DASHORE","TEJUS JAIN","PRAROOP PRAVEEN AGRAWAL","SHREE GUPTA","KAMAL CHAUHAN","SHREYA AMBHORE","RICHARD AMBROSE","S SHRI RAM KUMAR","VIPUL SINGH","TEJAS SINGH","PIYUSH SAINI","KUSHAGRA SINGH DHAUNI","SPANDAN VERMA","HATIM MUSTAFA MERCHANT","KARTIK KARANDIKAR","ALI AYMAN MALIK","ISHAAN JHAMB","ARYAN JACOB MATHEWS","VAIBHAV TIWARI","NEIL GHEVADE","AYUSH MISHRA","DIYA NARAYANAN","IRVIT GUPTA","DHRUV DUHAN","ROY ANEERBAN RAJA","NANDITA VAKEEL","ADITYA PATHAK","SARANSH GAUTAM","DIVYANSHU SINGH","MUSKAN DEORI","TALATI JAIVAL","AAKASH DEEPAK LAWANA","ARHAM SHREYANSH CHHAJER","ANJALI CHOUDHARY","NIMIT JAIN","NISHANT YADAV","KAUSHIK DWIVEDI","NAMAN GUPTA","YUVRAJ KHANNA","SHREYANSH JANGITWAR","SHREESH GUPTA","SARTHAK GOYAL","SUBHRANSHU SEKHAR PANDA","SARVESH KHANDELWAL","RADHIKA GUPTA","DIMPLE","KARAN MANOJ AGRAWAL","ARYAN RAMESH BARAPATRE","ANANTH VENKATESH","SRIJAN KHATRI","VARUN VARMA","RAUNAK BHALLA","HARSH NEEMA","AKSHAJ DIXIT","DHRUV SINGH","MADHAV NATH KHANNA","BHUVAN GUPTA","DIVIT P MALLAH","AKSHAT KUMAR","RIA SHEKHAWAT","PUSHPENDRA SINGH PAYAL","RACHIT GANDHI","PRATHAM ARYA","YERRABELLI AKSHAY","JATIN GUPTA","ARCHIT JAIN","ABHINAV GUPTA","KUNAL GUPTA","KANCHI SYAMA NIKITA JHANSI RED","NILAY MARU","ARYAMAN AGGARWAL","DEVANSH SHARMA","RICHA SINGH","RAHUL KIRORIWAL","ROMA","YANA UPADHYAY","GARVIT SHARMA","DEEPANSHU GUPTA","SHREYA MISHRA","ARYAN VERMA","YASH CHAUHAN","AMAN KUMAR SHUKLA","YASH GUPTA","ARYAN SINGH","RAGHIB ABDUZ  SAMEE","KARANVEER SINGH CHUNDAWAT","SAMARTH CHOUKSEY","YASH TYAGI","MAYANK KUMAR SINGH","KRISH LIMBANI","AYUSH ANAND BOURAI","HARSHIL AGRAWAL","ANSH DAS","AARYAV MISHRA","NIRANJAN CHAUDHARI","KHATRI MEET NARAYAN","ANSH MAHAPATRA","PRANAV BHASKARAN","AKSHAT SHARMA","GURUPAM DIXIT","MUKUL SHARMA","PRATHAM AGRAWAL","DEEP PATEL","ADITYA SHARMA","SARVAGYA GARG","SUYASH KUMAR","ABHIJIT PADHI","ADITYA GOEL","RITISH PURI","NEHIL SINGH","ARYAMAN DAS","ADITYA AGRAWAL","MADHAV CHAWLA","DIVYAN PODDAR","NANDALAL ODEDARA","ABHINAV SAHAY","VEDANG BHUPESH SHENVI NADKARNI","STAVYA PURI","ADARSH AGARWAL","POPURI SAI DHRUV","ALVIN ADARSH KUMAR","PRAKHAR PANDEY","DEVANSH","ARYAMAN CHAUHAN","NAKUL GUPTA","PINAPATI SAKETH","SUKRITI MATHUR","SYED MAAZ HUSAIN","ARYAJEET SINGH SAMRA","KRISHNA CHOPRA","SAJAL SHARMA","TAHA YUSUF RAJA","UDAYAGIRI ADISHREYES KUMAR","ANUBHAV PANDA","TRIDEEB BHATTACHARYA","ISHAN KHARE","UTKARSH SHUKLA","DOBARIYA NAITIK DINESHBHAI","SOHAM MUKHERJEE","G ADARSH CHANDRA","VALIVERU SAI SRIKAR","JAY KHANDKAR","MAMTA SINGH"};

vector <string> gender = {"M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","F","M","M","M","M","M","F","F","F","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","F","M","M","F","M","M","F","M","M","M","M","F","M","M","M","M","M","M","M","M","F","M","F","F","F","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","M","M","M","M","M","M","F","M","M","M","F","F","M","M","F","M","M","M","M","M","M","M","M","F","F","M","F","M","M","M","M","M","M","M","M","M","F","M","M","M","M","F","M","F","M","F","F","M","M","M","M","M","M","F","M","M","M","M","F","M","M","M","M","F","M","M","F","M","F","M","M","M","M","F","M","F","M","M","M","F","M","M","M","F","M","F","F","M","M","M","M","M","M","F","M","M","F","M","M","M","M","M","M","M","M","F","M","M","F","F","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","M","F","F","M","M","M","M","F","M","M","M","F","M","M","M","M","M","F","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","F","M","M","M","F","M","F","M","M","M","F","M","M","M","M","F","M","M","M","F","M","M","M","M","M","F","M","M","M","M","M","M","M","F","M","M","M","M","M","M","M","M","M","M","F","M","M","M","F","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","F","M","M","F","M","M","M","M","M","F","F","M","M","F","M","M","M","M","M","M","F","M","F","M","M","M","M","F","M","M","M","M","M","M","M","M","F","F","M","F","F","F","F","F","M","M","F","M","M","M","M","M","M","M","M","F","M","F","M","F","F","F","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","M","F","M","M","F","M","M","M","M","M","F","M","M","M","M","F","M","M","M","M","F","F","M","M","M","M","F","M","M","M","M","M","F","F","M","F","M","M","M","M","M","M","M","M","M","M","F","M","F","F","M","M","M","M","F","M","F","M","M","M","M","M","M","M","M","M","M","M","M","M","M","M","F","M","M","M","M","M","F","M"};

vector <string> email = {"f20200001@pilani.bits-pilani.ac.in","f20200002@pilani.bits-pilani.ac.in","f20200003@pilani.bits-pilani.ac.in","f20200004@pilani.bits-pilani.ac.in","f20200005@pilani.bits-pilani.ac.in","f20200006@pilani.bits-pilani.ac.in","f20200007@pilani.bits-pilani.ac.in","f20200010@pilani.bits-pilani.ac.in","f20200012@pilani.bits-pilani.ac.in","f20200013@pilani.bits-pilani.ac.in","f20200014@pilani.bits-pilani.ac.in","f20200016@pilani.bits-pilani.ac.in","f20200017@pilani.bits-pilani.ac.in","f20200020@pilani.bits-pilani.ac.in","f20200021@pilani.bits-pilani.ac.in","f20200024@pilani.bits-pilani.ac.in","f20200025@pilani.bits-pilani.ac.in","f20200026@pilani.bits-pilani.ac.in","f20200032@pilani.bits-pilani.ac.in","f20200033@pilani.bits-pilani.ac.in","f20200035@pilani.bits-pilani.ac.in","f20200036@pilani.bits-pilani.ac.in","f20200037@pilani.bits-pilani.ac.in","f20200040@pilani.bits-pilani.ac.in","f20200043@pilani.bits-pilani.ac.in","f20200045@pilani.bits-pilani.ac.in","f20200048@pilani.bits-pilani.ac.in","f20200049@pilani.bits-pilani.ac.in","f20200050@pilani.bits-pilani.ac.in","f20200054@pilani.bits-pilani.ac.in","f20200057@pilani.bits-pilani.ac.in","f20200059@pilani.bits-pilani.ac.in","f20200060@pilani.bits-pilani.ac.in","f20200064@pilani.bits-pilani.ac.in","f20200065@pilani.bits-pilani.ac.in","f20200066@pilani.bits-pilani.ac.in","f20200067@pilani.bits-pilani.ac.in","f20200069@pilani.bits-pilani.ac.in","f20200071@pilani.bits-pilani.ac.in","f20200072@pilani.bits-pilani.ac.in","f20200073@pilani.bits-pilani.ac.in","f20200075@pilani.bits-pilani.ac.in","f20200077@pilani.bits-pilani.ac.in","f20200081@pilani.bits-pilani.ac.in","f20200082@pilani.bits-pilani.ac.in","f20200083@pilani.bits-pilani.ac.in","f20200084@pilani.bits-pilani.ac.in","f20200087@pilani.bits-pilani.ac.in","f20200088@pilani.bits-pilani.ac.in","f20200089@pilani.bits-pilani.ac.in","f20200090@pilani.bits-pilani.ac.in","f20200092@pilani.bits-pilani.ac.in","f20200093@pilani.bits-pilani.ac.in","f20200094@pilani.bits-pilani.ac.in","f20200095@pilani.bits-pilani.ac.in","f20200096@pilani.bits-pilani.ac.in","f20200098@pilani.bits-pilani.ac.in","f20200100@pilani.bits-pilani.ac.in","f20200101@pilani.bits-pilani.ac.in","f20200102@pilani.bits-pilani.ac.in","f20200104@pilani.bits-pilani.ac.in","f20200105@pilani.bits-pilani.ac.in","f20200106@pilani.bits-pilani.ac.in","f20200107@pilani.bits-pilani.ac.in","f20200108@pilani.bits-pilani.ac.in","f20200110@pilani.bits-pilani.ac.in","f20200111@pilani.bits-pilani.ac.in","f20200112@pilani.bits-pilani.ac.in","f20200113@pilani.bits-pilani.ac.in","f20200114@pilani.bits-pilani.ac.in","f20200116@pilani.bits-pilani.ac.in","f20200119@pilani.bits-pilani.ac.in","f20200120@pilani.bits-pilani.ac.in","f20200121@pilani.bits-pilani.ac.in","f20200123@pilani.bits-pilani.ac.in","f20200124@pilani.bits-pilani.ac.in","f20200128@pilani.bits-pilani.ac.in","f20200129@pilani.bits-pilani.ac.in","f20200131@pilani.bits-pilani.ac.in","f20200133@pilani.bits-pilani.ac.in","f20200134@pilani.bits-pilani.ac.in","f20200139@pilani.bits-pilani.ac.in","f20200140@pilani.bits-pilani.ac.in","f20200144@pilani.bits-pilani.ac.in","f20200145@pilani.bits-pilani.ac.in","f20200146@pilani.bits-pilani.ac.in","f20200148@pilani.bits-pilani.ac.in","f20200297@pilani.bits-pilani.ac.in","f20200299@pilani.bits-pilani.ac.in","f20200309@pilani.bits-pilani.ac.in","f20200310@pilani.bits-pilani.ac.in","f20200311@pilani.bits-pilani.ac.in","f20200313@pilani.bits-pilani.ac.in","f20200315@pilani.bits-pilani.ac.in","f20200970@pilani.bits-pilani.ac.in","f20200971@pilani.bits-pilani.ac.in","f20200972@pilani.bits-pilani.ac.in","f20200973@pilani.bits-pilani.ac.in","f20200974@pilani.bits-pilani.ac.in","f20200975@pilani.bits-pilani.ac.in","f20200979@pilani.bits-pilani.ac.in","f20200980@pilani.bits-pilani.ac.in","f20200981@pilani.bits-pilani.ac.in","f20200983@pilani.bits-pilani.ac.in","f20200984@pilani.bits-pilani.ac.in","f20200986@pilani.bits-pilani.ac.in","f20200987@pilani.bits-pilani.ac.in","f20200988@pilani.bits-pilani.ac.in","f20200991@pilani.bits-pilani.ac.in","f20200993@pilani.bits-pilani.ac.in","f20200994@pilani.bits-pilani.ac.in","f20200995@pilani.bits-pilani.ac.in","f20201201@pilani.bits-pilani.ac.in","f20201202@pilani.bits-pilani.ac.in","f20201205@pilani.bits-pilani.ac.in","f20201206@pilani.bits-pilani.ac.in","f20201207@pilani.bits-pilani.ac.in","f20201208@pilani.bits-pilani.ac.in","f20201209@pilani.bits-pilani.ac.in","f20201210@pilani.bits-pilani.ac.in","f20201211@pilani.bits-pilani.ac.in","f20201212@pilani.bits-pilani.ac.in","f20201214@pilani.bits-pilani.ac.in","f20201507@pilani.bits-pilani.ac.in","f20201509@pilani.bits-pilani.ac.in","f20201510@pilani.bits-pilani.ac.in","f20201511@pilani.bits-pilani.ac.in","f20201512@pilani.bits-pilani.ac.in","f20201513@pilani.bits-pilani.ac.in","f20201515@pilani.bits-pilani.ac.in","f20201675@pilani.bits-pilani.ac.in","f20201677@pilani.bits-pilani.ac.in","f20201678@pilani.bits-pilani.ac.in","f20201679@pilani.bits-pilani.ac.in","f20201680@pilani.bits-pilani.ac.in","f20201681@pilani.bits-pilani.ac.in","f20201683@pilani.bits-pilani.ac.in","f20201684@pilani.bits-pilani.ac.in","f20201686@pilani.bits-pilani.ac.in","f20201687@pilani.bits-pilani.ac.in","f20201688@pilani.bits-pilani.ac.in","f20201689@pilani.bits-pilani.ac.in","f20201690@pilani.bits-pilani.ac.in","f20201691@pilani.bits-pilani.ac.in","f20201692@pilani.bits-pilani.ac.in","f20202051@pilani.bits-pilani.ac.in","f20200456@pilani.bits-pilani.ac.in","f20200533@pilani.bits-pilani.ac.in","f20200537@pilani.bits-pilani.ac.in","f20200542@pilani.bits-pilani.ac.in","f20200547@pilani.bits-pilani.ac.in","f20200549@pilani.bits-pilani.ac.in","f20200552@pilani.bits-pilani.ac.in","f20200554@pilani.bits-pilani.ac.in","f20200570@pilani.bits-pilani.ac.in","f20200572@pilani.bits-pilani.ac.in","f20200573@pilani.bits-pilani.ac.in","f20200582@pilani.bits-pilani.ac.in","f20200782@pilani.bits-pilani.ac.in","f20200804@pilani.bits-pilani.ac.in","f20200807@pilani.bits-pilani.ac.in","f20200818@pilani.bits-pilani.ac.in","f20200819@pilani.bits-pilani.ac.in","f20200832@pilani.bits-pilani.ac.in","f20200901@pilani.bits-pilani.ac.in","f20201043@pilani.bits-pilani.ac.in","f20201541@pilani.bits-pilani.ac.in","f20201549@pilani.bits-pilani.ac.in","f20201553@pilani.bits-pilani.ac.in","f20201556@pilani.bits-pilani.ac.in","f20201558@pilani.bits-pilani.ac.in","f20201562@pilani.bits-pilani.ac.in","f20201790@pilani.bits-pilani.ac.in","f20201791@pilani.bits-pilani.ac.in","f20201792@pilani.bits-pilani.ac.in","f20201793@pilani.bits-pilani.ac.in","f20201794@pilani.bits-pilani.ac.in","f20201795@pilani.bits-pilani.ac.in","f20201796@pilani.bits-pilani.ac.in","f20201798@pilani.bits-pilani.ac.in","f20201799@pilani.bits-pilani.ac.in","f20201800@pilani.bits-pilani.ac.in","f20201801@pilani.bits-pilani.ac.in","f20201802@pilani.bits-pilani.ac.in","f20201803@pilani.bits-pilani.ac.in","f20201804@pilani.bits-pilani.ac.in","f20201805@pilani.bits-pilani.ac.in","f20201806@pilani.bits-pilani.ac.in","f20201807@pilani.bits-pilani.ac.in","f20201808@pilani.bits-pilani.ac.in","f20201809@pilani.bits-pilani.ac.in","f20201810@pilani.bits-pilani.ac.in","f20201812@pilani.bits-pilani.ac.in","f20201813@pilani.bits-pilani.ac.in","f20201814@pilani.bits-pilani.ac.in","f20201816@pilani.bits-pilani.ac.in","f20201817@pilani.bits-pilani.ac.in","f20201818@pilani.bits-pilani.ac.in","f20201819@pilani.bits-pilani.ac.in","f20201820@pilani.bits-pilani.ac.in","f20201821@pilani.bits-pilani.ac.in","f20201822@pilani.bits-pilani.ac.in","f20201825@pilani.bits-pilani.ac.in","f20201826@pilani.bits-pilani.ac.in","f20201828@pilani.bits-pilani.ac.in","f20201829@pilani.bits-pilani.ac.in","f20200489@pilani.bits-pilani.ac.in","f20200635@pilani.bits-pilani.ac.in","f20200640@pilani.bits-pilani.ac.in","f20201048@pilani.bits-pilani.ac.in","f20201051@pilani.bits-pilani.ac.in","f20201065@pilani.bits-pilani.ac.in","f20201067@pilani.bits-pilani.ac.in","f20201575@pilani.bits-pilani.ac.in","f20201577@pilani.bits-pilani.ac.in","f20201830@pilani.bits-pilani.ac.in","f20201831@pilani.bits-pilani.ac.in","f20201832@pilani.bits-pilani.ac.in","f20201833@pilani.bits-pilani.ac.in","f20201834@pilani.bits-pilani.ac.in","f20201837@pilani.bits-pilani.ac.in","f20201838@pilani.bits-pilani.ac.in","f20201840@pilani.bits-pilani.ac.in","f20201841@pilani.bits-pilani.ac.in","f20201843@pilani.bits-pilani.ac.in","f20201844@pilani.bits-pilani.ac.in","f20201845@pilani.bits-pilani.ac.in","f20201846@pilani.bits-pilani.ac.in","f20201847@pilani.bits-pilani.ac.in","f20201848@pilani.bits-pilani.ac.in","f20201849@pilani.bits-pilani.ac.in","f20201850@pilani.bits-pilani.ac.in","f20201851@pilani.bits-pilani.ac.in","f20201852@pilani.bits-pilani.ac.in","f20201853@pilani.bits-pilani.ac.in","f20201854@pilani.bits-pilani.ac.in","f20201856@pilani.bits-pilani.ac.in","f20201857@pilani.bits-pilani.ac.in","f20201858@pilani.bits-pilani.ac.in","f20201861@pilani.bits-pilani.ac.in","f20200615@pilani.bits-pilani.ac.in","f20200617@pilani.bits-pilani.ac.in","f20200641@pilani.bits-pilani.ac.in","f20200662@pilani.bits-pilani.ac.in","f20201226@pilani.bits-pilani.ac.in","f20201385@pilani.bits-pilani.ac.in","f20201609@pilani.bits-pilani.ac.in","f20201888@pilani.bits-pilani.ac.in","f20201897@pilani.bits-pilani.ac.in","f20201898@pilani.bits-pilani.ac.in","f20201899@pilani.bits-pilani.ac.in","f20201906@pilani.bits-pilani.ac.in","f20200658@pilani.bits-pilani.ac.in","f20201613@pilani.bits-pilani.ac.in","f20200602@pilani.bits-pilani.ac.in","f20200660@pilani.bits-pilani.ac.in","f20201231@pilani.bits-pilani.ac.in","f20201392@pilani.bits-pilani.ac.in","f20201610@pilani.bits-pilani.ac.in","f20201904@pilani.bits-pilani.ac.in","f20201910@pilani.bits-pilani.ac.in","f20200593@pilani.bits-pilani.ac.in","f20200601@pilani.bits-pilani.ac.in","f20200616@pilani.bits-pilani.ac.in","f20200621@pilani.bits-pilani.ac.in","f20200651@pilani.bits-pilani.ac.in","f20200652@pilani.bits-pilani.ac.in","f20200656@pilani.bits-pilani.ac.in","f20201396@pilani.bits-pilani.ac.in",
"f20201607@pilani.bits-pilani.ac.in","f20201889@pilani.bits-pilani.ac.in","f20201909@pilani.bits-pilani.ac.in","f20201912@pilani.bits-pilani.ac.in","f20201913@pilani.bits-pilani.ac.in","f20200603@pilani.bits-pilani.ac.in","f20200611@pilani.bits-pilani.ac.in","f20200623@pilani.bits-pilani.ac.in","f20200630@pilani.bits-pilani.ac.in","f20200648@pilani.bits-pilani.ac.in","f20201380@pilani.bits-pilani.ac.in","f20201602@pilani.bits-pilani.ac.in","f20201605@pilani.bits-pilani.ac.in","f20201612@pilani.bits-pilani.ac.in","f20201896@pilani.bits-pilani.ac.in","f20201902@pilani.bits-pilani.ac.in","f20201942@pilani.bits-pilani.ac.in","f20200609@pilani.bits-pilani.ac.in","f20200668@pilani.bits-pilani.ac.in","f20201914@pilani.bits-pilani.ac.in","f20201379@pilani.bits-pilani.ac.in","f20201890@pilani.bits-pilani.ac.in","f20200669@pilani.bits-pilani.ac.in","f20200671@pilani.bits-pilani.ac.in","f20201141@pilani.bits-pilani.ac.in","f20201377@pilani.bits-pilani.ac.in","f20201381@pilani.bits-pilani.ac.in","f20201386@pilani.bits-pilani.ac.in","f20201893@pilani.bits-pilani.ac.in","f20201901@pilani.bits-pilani.ac.in","f20201903@pilani.bits-pilani.ac.in","f20201905@pilani.bits-pilani.ac.in","f20201908@pilani.bits-pilani.ac.in","f20201915@pilani.bits-pilani.ac.in","f20201916@pilani.bits-pilani.ac.in","f20201252@pilani.bits-pilani.ac.in","f20201287@pilani.bits-pilani.ac.in","f20200647@pilani.bits-pilani.ac.in","f20200649@pilani.bits-pilani.ac.in","f20201617@pilani.bits-pilani.ac.in","f20201918@pilani.bits-pilani.ac.in","f20201928@pilani.bits-pilani.ac.in","f20201941@pilani.bits-pilani.ac.in","f20201944@pilani.bits-pilani.ac.in","f20201950@pilani.bits-pilani.ac.in","f20201951@pilani.bits-pilani.ac.in","f20200745@pilani.bits-pilani.ac.in","f20201145@pilani.bits-pilani.ac.in","f20201636@pilani.bits-pilani.ac.in","f20201920@pilani.bits-pilani.ac.in","f20201923@pilani.bits-pilani.ac.in","f20201925@pilani.bits-pilani.ac.in","f20201940@pilani.bits-pilani.ac.in","f20200637@pilani.bits-pilani.ac.in","f20200654@pilani.bits-pilani.ac.in","f20200704@pilani.bits-pilani.ac.in","f20201619@pilani.bits-pilani.ac.in","f20201623@pilani.bits-pilani.ac.in","f20201921@pilani.bits-pilani.ac.in","f20201922@pilani.bits-pilani.ac.in","f20201927@pilani.bits-pilani.ac.in","f20201954@pilani.bits-pilani.ac.in","f20200703@pilani.bits-pilani.ac.in","f20200711@pilani.bits-pilani.ac.in","f20200733@pilani.bits-pilani.ac.in","f20201401@pilani.bits-pilani.ac.in","f20201412@pilani.bits-pilani.ac.in","f20201926@pilani.bits-pilani.ac.in","f20201931@pilani.bits-pilani.ac.in","f20201943@pilani.bits-pilani.ac.in","f20201947@pilani.bits-pilani.ac.in","f20201949@pilani.bits-pilani.ac.in","f20201952@pilani.bits-pilani.ac.in","f20201955@pilani.bits-pilani.ac.in","f20200633@pilani.bits-pilani.ac.in","f20200687@pilani.bits-pilani.ac.in","f20200709@pilani.bits-pilani.ac.in","f20200731@pilani.bits-pilani.ac.in","f20201136@pilani.bits-pilani.ac.in","f20201406@pilani.bits-pilani.ac.in","f20201611@pilani.bits-pilani.ac.in","f20201932@pilani.bits-pilani.ac.in","f20201945@pilani.bits-pilani.ac.in","f20201413@pilani.bits-pilani.ac.in","f20201624@pilani.bits-pilani.ac.in","f20201635@pilani.bits-pilani.ac.in","f20201924@pilani.bits-pilani.ac.in","f20201929@pilani.bits-pilani.ac.in","f20201938@pilani.bits-pilani.ac.in","f20201948@pilani.bits-pilani.ac.in","f20200722@pilani.bits-pilani.ac.in","f20201146@pilani.bits-pilani.ac.in","f20201403@pilani.bits-pilani.ac.in","f20201946@pilani.bits-pilani.ac.in","f20201917@pilani.bits-pilani.ac.in","f20201254@pilani.bits-pilani.ac.in","f20201283@pilani.bits-pilani.ac.in","f20201286@pilani.bits-pilani.ac.in","f20201300@pilani.bits-pilani.ac.in","f20200690@pilani.bits-pilani.ac.in","f20201469@pilani.bits-pilani.ac.in","f20201655@pilani.bits-pilani.ac.in","f20201983@pilani.bits-pilani.ac.in","f20200737@pilani.bits-pilani.ac.in","f20200881@pilani.bits-pilani.ac.in","f20201973@pilani.bits-pilani.ac.in","f20201980@pilani.bits-pilani.ac.in","f20201981@pilani.bits-pilani.ac.in","f20201993@pilani.bits-pilani.ac.in","f20200694@pilani.bits-pilani.ac.in","f20200726@pilani.bits-pilani.ac.in","f20200853@pilani.bits-pilani.ac.in","f20200876@pilani.bits-pilani.ac.in","f20201235@pilani.bits-pilani.ac.in","f20201448@pilani.bits-pilani.ac.in","f20201476@pilani.bits-pilani.ac.in","f20201647@pilani.bits-pilani.ac.in","f20201649@pilani.bits-pilani.ac.in","f20201650@pilani.bits-pilani.ac.in","f20201977@pilani.bits-pilani.ac.in","f20201979@pilani.bits-pilani.ac.in","f20201987@pilani.bits-pilani.ac.in","f20201995@pilani.bits-pilani.ac.in","f20200683@pilani.bits-pilani.ac.in","f20200710@pilani.bits-pilani.ac.in","f20200735@pilani.bits-pilani.ac.in","f20200954@pilani.bits-pilani.ac.in","f20201446@pilani.bits-pilani.ac.in","f20201974@pilani.bits-pilani.ac.in","f20201978@pilani.bits-pilani.ac.in","f20201988@pilani.bits-pilani.ac.in","f20201990@pilani.bits-pilani.ac.in","f20200600@pilani.bits-pilani.ac.in","f20200632@pilani.bits-pilani.ac.in","f20200830@pilani.bits-pilani.ac.in","f20200833@pilani.bits-pilani.ac.in","f20200834@pilani.bits-pilani.ac.in","f20200836@pilani.bits-pilani.ac.in","f20200844@pilani.bits-pilani.ac.in","f20200859@pilani.bits-pilani.ac.in","f20200878@pilani.bits-pilani.ac.in","f20200948@pilani.bits-pilani.ac.in","f20200969@pilani.bits-pilani.ac.in","f20201325@pilani.bits-pilani.ac.in","f20201654@pilani.bits-pilani.ac.in","f20201975@pilani.bits-pilani.ac.in","f20201976@pilani.bits-pilani.ac.in","f20201986@pilani.bits-pilani.ac.in","f20200824@pilani.bits-pilani.ac.in","f20201440@pilani.bits-pilani.ac.in","f20201658@pilani.bits-pilani.ac.in","f20201984@pilani.bits-pilani.ac.in","f20201989@pilani.bits-pilani.ac.in","f20201994@pilani.bits-pilani.ac.in","f20201996@pilani.bits-pilani.ac.in","f20200474@pilani.bits-pilani.ac.in","f20200607@pilani.bits-pilani.ac.in","f20201331@pilani.bits-pilani.ac.in","f20201982@pilani.bits-pilani.ac.in","f20201991@pilani.bits-pilani.ac.in","f20201453@pilani.bits-pilani.ac.in","f20201258@pilani.bits-pilani.ac.in","f20201261@pilani.bits-pilani.ac.in","f20201273@pilani.bits-pilani.ac.in","f20201274@pilani.bits-pilani.ac.in","f20201276@pilani.bits-pilani.ac.in","f20201278@pilani.bits-pilani.ac.in","f20200678@pilani.bits-pilani.ac.in","f20200688@pilani.bits-pilani.ac.in","f20200921@pilani.bits-pilani.ac.in","f20201459@pilani.bits-pilani.ac.in","f20201665@pilani.bits-pilani.ac.in","f20201673@pilani.bits-pilani.ac.in","f20202002@pilani.bits-pilani.ac.in","f20200614@pilani.bits-pilani.ac.in","f20200718@pilani.bits-pilani.ac.in","f20201462@pilani.bits-pilani.ac.in","f20201485@pilani.bits-pilani.ac.in","f20201659@pilani.bits-pilani.ac.in","f20201666@pilani.bits-pilani.ac.in","f20201999@pilani.bits-pilani.ac.in","f20200926@pilani.bits-pilani.ac.in","f20200929@pilani.bits-pilani.ac.in","f20200932@pilani.bits-pilani.ac.in","f20200945@pilani.bits-pilani.ac.in","f20201662@pilani.bits-pilani.ac.in","f20202008@pilani.bits-pilani.ac.in","f20200627@pilani.bits-pilani.ac.in","f20200628@pilani.bits-pilani.ac.in","f20200744@pilani.bits-pilani.ac.in","f20200960@pilani.bits-pilani.ac.in","f20200967@pilani.bits-pilani.ac.in","f20201336@pilani.bits-pilani.ac.in","f20201454@pilani.bits-pilani.ac.in","f20201457@pilani.bits-pilani.ac.in","f20201458@pilani.bits-pilani.ac.in","f20201664@pilani.bits-pilani.ac.in","f20201671@pilani.bits-pilani.ac.in","f20201672@pilani.bits-pilani.ac.in","f20202010@pilani.bits-pilani.ac.in","f20202012@pilani.bits-pilani.ac.in","f20200604@pilani.bits-pilani.ac.in","f20200693@pilani.bits-pilani.ac.in","f20200788@pilani.bits-pilani.ac.in","f20200897@pilani.bits-pilani.ac.in","f20200912@pilani.bits-pilani.ac.in","f20200924@pilani.bits-pilani.ac.in","f20200930@pilani.bits-pilani.ac.in","f20200931@pilani.bits-pilani.ac.in","f20200951@pilani.bits-pilani.ac.in","f20202001@pilani.bits-pilani.ac.in","f20202006@pilani.bits-pilani.ac.in","f20200925@pilani.bits-pilani.ac.in","f20200966@pilani.bits-pilani.ac.in","f20201399@pilani.bits-pilani.ac.in","f20202052@pilani.bits-pilani.ac.in","f20200698@pilani.bits-pilani.ac.in","f20200719@pilani.bits-pilani.ac.in","f20200740@pilani.bits-pilani.ac.in","f20200910@pilani.bits-pilani.ac.in","f20200915@pilani.bits-pilani.ac.in","f20200947@pilani.bits-pilani.ac.in","f20201398@pilani.bits-pilani.ac.in","f20201471@pilani.bits-pilani.ac.in","f20202007@pilani.bits-pilani.ac.in","f20200900@pilani.bits-pilani.ac.in","f20202004@pilani.bits-pilani.ac.in","f20202005@pilani.bits-pilani.ac.in","f20200905@pilani.bits-pilani.ac.in","f20201998@pilani.bits-pilani.ac.in","f20201251@pilani.bits-pilani.ac.in"};


int main() {

    int i = 0;
    while(i < 600) {
        cout << "INSERT INTO room VALUES (\"";
        if(i < 200) {
            cout << "BD\",";
            if(i < 120) {
                cout << (2000 + 1 + (i/2)) << ",2);" << endl;
                i += 2;
            } else {
                cout << (1000 + 1 + i - 120) << ",1);" << endl;
                i += 1;
            }
        } else if(i < 450) {
            cout << "SK\",";
            if(i < 340) {
                cout << (4000 + 1 + ((i - 200)/2)) << ",2);" << endl;
                i += 2;
            } else {
                cout << (3000 + 1 + i - 340) << ",1);" << endl;
                i += 1;
            }
        } else {
            cout << "MR\",";
            if(i < 530) {
                cout << (200 + 1 + ((i-450)/2)) << ",2);" << endl;
                i += 2;
            } else {
                cout << (100 + 1 + i - 530) << ",1);" << endl;
                i += 1;
            }
        }
    }

    // for(int i = 0; i < 500; i++) {
    //     cout << "INSERT INTO student VALUES (\"" << id[i] << "\",\"" << name[i] << "\",\"" << gender[i] << "\",\"" << email[i] << "\", NULL);" << endl;
    // }

    return 0;
}