package org.example.EasyAlgorithms;

import org.example.AlgorithmTasks.EasyAlgorithms.part3.LinkedListCycle.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.example.AlgorithmTasks.EasyAlgorithms.part3.ArrayRotation.Result.circularArrayRotation;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.ArrayRotation.Result.permutationEquation;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.DesignerPdfViewer.DesignerPdfViewer.designerPdfViewer;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.EqualizeArray.EqualizeArrayTask.equalizeArray;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.GradingStudents.StudentsAndGradesUtil.gradingStudents;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.JumpingOnClouds.CloudsUtils.jumpingOnClouds;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.LibraryFine.LibraryFine.libraryFine;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.LinkedListCycle.NodeCycleUtil.hasCycle;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.RepeatedString.RepeatedString.repeatedString;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.SavePrisoner.SaveThePrisonerUtils.saveThePrisoner;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.SpecialMultiply.SpecialMultiply.multiply;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.Stackparcer.ParserUtils.isBalanced;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.UtopianTree.Part3Utils.*;
import static org.example.AlgorithmTasks.EasyAlgorithms.part3.ViralAdvertising.ViralAdvertisingUtils.viralAdvertising;
import static org.example.AlgorithmTasks.MediumAlgorithms.NonDivisibleSubset.NonDivisibleSubset.nonDivisibleSubset;
import static org.example.utils.AlgArrayUtils.createIntegerArrayList;
import static org.junit.Assert.*;


public class TestPart3 {

    @Test
    public void testCircularArrayRotation() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        int k = 3;
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(3);
        queries.add(5);

        assert circularArrayRotation(a, k, queries).equals(new ArrayList<>(List.of(8, 1, 3)));
    }

    @Test
    public void testPermutationEquation() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(4);
        integerList.add(1);
        integerList.add(7);
        integerList.add(2);
        integerList.add(8);
        integerList.add(9);
        integerList.add(5);
        integerList.add(6);

        assert permutationEquation(integerList).equals(new ArrayList<>(List.of(1, 8, 3, 5, 6, 7, 2, 9, 4)));

    }

    @Test
    public void testDesignerPdfViewer() {
        List<Integer> highList = new ArrayList<>();
        highList.add(3);// a
        highList.add(5);// b
        highList.add(3);// c
        highList.add(5);// d
        highList.add(3);// e
        highList.add(5);// f
        highList.add(5);// g
        highList.add(5);// h
        highList.add(3);// i
        highList.add(5);// j
        highList.add(4);// k
        highList.add(5);// l
        highList.add(3);// m
        highList.add(3);// n
        highList.add(3);// o
        highList.add(5);// p
        highList.add(5);// q
        highList.add(3);// r
        highList.add(3);// s
        highList.add(6);// t
        highList.add(3);// u
        highList.add(3);// v
        highList.add(3);// w
        highList.add(3);// x
        highList.add(3);// y
        highList.add(3);// z

        assertEquals(168, designerPdfViewer(highList, "this words @@ with spaces and digits"));
        assertEquals(42, designerPdfViewer(highList, "correct"));
    }

    @Test
    public void testGradingStudents() {
        List<Integer> gradeList = new ArrayList<>();
        gradeList.add(38);
        gradeList.add(25);
        gradeList.add(7);
        gradeList.add(58);
        gradeList.add(45);
        gradeList.add(73);
        assert gradingStudents(gradeList).equals(new ArrayList<>(List.of(40, 25, 7, 60, 45, 75)));
    }

    @Test
    public void testJumpingOnClouds() {

        int returnCycles = jumpingOnClouds(new int[]{1, 3, 4, 6, 7, 8}, 3);
        System.out.println(returnCycles);
        assertEquals(84, returnCycles);

        returnCycles = jumpingOnClouds(new int[]{2, 4, 2, 3}, 2);
        System.out.println(returnCycles);
        assertEquals(90, returnCycles);

    }

    @Test
    public void testHasCycle() {
        ListNode headListNode = new ListNode(1);
        ListNode secondLevelListNode = new ListNode(2);
        headListNode.setNext(secondLevelListNode);
        ListNode thirdLevelListNode = new ListNode(3);
        secondLevelListNode.setNext(thirdLevelListNode);
        ListNode fourthLevelListNode = new ListNode(4);
        thirdLevelListNode.setNext(fourthLevelListNode);
        fourthLevelListNode.setNext(headListNode); // create cycle
        ListNode fifthLevelListNode = new ListNode(5); // unusable Node
        assertTrue(hasCycle(headListNode));

        fourthLevelListNode.setNext(fifthLevelListNode); // delete cycle
        assertFalse(hasCycle(headListNode));

    }

    @Test
    public void testSaveThePrisoner() {
        assertEquals(saveThePrisoner(10, 2, 3), 4);
        assertEquals(saveThePrisoner(11, 30, 7), 3);
        assertEquals(saveThePrisoner(12, 123, 10), 12);
        assertEquals(saveThePrisoner(13, 23, 5), 1);
        assertEquals(saveThePrisoner(13023, 2323231, 342), 5478);
    }

    @Test
    public void testIsBalanced() {
        assertTrue(isBalanced("{}{}{}{}{}{}"));
        assertTrue(isBalanced("(({{}}{({(({}))})}))"));
        assertTrue(isBalanced("{}()"));
        assertTrue(isBalanced("((()){}(){()}(()))"));

        assertFalse(isBalanced("(({}({}{(}{)}){}{}))"));
        assertFalse(isBalanced("{()({}{())}})}"));
    }

    @Test
    public void testUtopianTree() {
        assertEquals(utopianTree(60), 2147483647);
        assertEquals(utopianTree(0), 1);
        assertEquals(utopianTree(100), -1);
        assertEquals(utopianTree(34), 262143);

    }

    @Test
    public void testAngryProfessor() {
        final String YES = "YES";
        final String NO = "NO";
        List<Integer> minutesAfterStartList = new ArrayList<>();
        minutesAfterStartList.add(13);
        minutesAfterStartList.add(10);
        minutesAfterStartList.add(-20);
        minutesAfterStartList.add(1);
        minutesAfterStartList.add(34);
        minutesAfterStartList.add(50);
        minutesAfterStartList.add(-5);
        minutesAfterStartList.add(-3);
        minutesAfterStartList.add(8);
        assertEquals(YES, angryProfessor(30, minutesAfterStartList));
        assertEquals(NO, angryProfessor(0, minutesAfterStartList));
        assertEquals(YES, angryProfessor(5, minutesAfterStartList));
        assertEquals(NO, angryProfessor(3, minutesAfterStartList));
    }

    @Test
    public void testBeautifulDays() {
        assertEquals(beautifulDays(1, 30, 2), 19);
        assertEquals(beautifulDays(10, 30, 2), 10);
        assertEquals(beautifulDays(10, 30, 3), 21);
        assertEquals(beautifulDays(20, 29, 5), 2);
        assertEquals(beautifulDays(12, 12, 7), 0);
    }

    @Test
    public void testViralAdvertising() {
        assertEquals(viralAdvertising(1), 2);
        assertEquals(viralAdvertising(10), 189);
        assertEquals(viralAdvertising(20), 10796);
        assertEquals(viralAdvertising(30), 622157);
        assertEquals(viralAdvertising(40), 35875988);
    }

    @Test
    public void testLibraryFine() {
        assertEquals(libraryFine(1, 6, 2015, 1, 6, 2015), 0);
        assertEquals(libraryFine(1, 10, 2015, 6, 6, 2015), 2000);
        assertEquals(libraryFine(1, 8, 2015, 1, 7, 2015), 500);
        assertEquals(libraryFine(1, 7, 2016, 1, 8, 2015), 10000);

        assertEquals(libraryFine(1, 3, 2015, 6, 6, 2015), 0);
        assertEquals(libraryFine(1, 6, 2015, 1, 7, 2015), 0);
        assertEquals(libraryFine(1, 7, 2014, 1, 8, 2015), 0);
    }

    @Test
    public void testNonDivisibleSubset() {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(7);
        listOfIntegers.add(2);
        listOfIntegers.add(4);
        int result = nonDivisibleSubset(3, listOfIntegers);
        assertEquals(3, result);
        listOfIntegers.clear();
        listOfIntegers.add(278);
        listOfIntegers.add(576);
        listOfIntegers.add(496);
        listOfIntegers.add(727);
        listOfIntegers.add(410);
        listOfIntegers.add(124);
        listOfIntegers.add(338);
        listOfIntegers.add(149);
        listOfIntegers.add(209);
        listOfIntegers.add(702);
        listOfIntegers.add(282);
        listOfIntegers.add(718);
        listOfIntegers.add(771);
        listOfIntegers.add(575);
        listOfIntegers.add(436);
        result = nonDivisibleSubset(7, listOfIntegers);
        assertEquals(11, result);
        listOfIntegers.clear();
        listOfIntegers.add(770528134);
        listOfIntegers.add(663501748);
        listOfIntegers.add(384261537);
        listOfIntegers.add(800309024);
        listOfIntegers.add(103668401);
        listOfIntegers.add(538539662);
        listOfIntegers.add(385488901);
        listOfIntegers.add(101262949);
        listOfIntegers.add(557792122);
        listOfIntegers.add(46058493);
        result = nonDivisibleSubset(5, listOfIntegers);
        assertEquals(6, result);
    }

    @Test
    public void testRepeatedString() {
        assertEquals(7, repeatedString("aba", 10));
        assertEquals(9, repeatedString("abcab", 23));
        assertEquals(1000000000000L, repeatedString("a", 1000000000000L));
        String s = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
        assertEquals(51574523448L, repeatedString(s, 736778906400L));

    }

    @Test
    public void testOptionalAndList() {
        List<String> testList = new ArrayList<>();
        testList.add("A");
        testList.add("A");
        testList.add("A");
        testList.add("A");
        testList.add("A");

        Optional<String> b = testList.stream().filter(a -> a.equalsIgnoreCase("X")).findFirst();

        if (b.isEmpty()) {
            System.out.println("EMPTY");
        }

        List<String> bList = testList.stream().filter(a -> a.equalsIgnoreCase("X")).collect(Collectors.toList());

        if (bList.isEmpty()) {
            System.out.println("EMPTY LIST");
        }

        testList.add("X");

        b = Optional.ofNullable(
                testList.stream().filter(a -> a.equalsIgnoreCase("X")).toList().get(0)
        );

        if (b.isPresent()) {
            System.out.println("BINGO");
        }

        bList = testList.stream().filter(a -> a.equalsIgnoreCase("X")).collect(Collectors.toList());

        if (bList.size() > 0) {
            System.out.println("BINGO LIST");
        }

    }

    @Test
    public void testStreamApiWithMap() {

        class DTODestinationBalanceEvent {
            String orderNumber;

            public DTODestinationBalanceEvent(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            @Override
            public String toString() {
                return "DTODestinationBalanceEvent{" +
                        "orderNumber='" + orderNumber + '\'' +
                        '}';
            }
        }
        class DTOTransferEntity {

            private String sourceEvent;
            private DTODestinationBalanceEvent destinationEvent;

            public DTOTransferEntity(String sourceEvent, DTODestinationBalanceEvent destinationEvent) {
                this.sourceEvent = sourceEvent;
                this.destinationEvent = destinationEvent;
            }

            public DTODestinationBalanceEvent getDestinationEvent() {
                return destinationEvent;
            }
        }
        List<DTOTransferEntity> items = new ArrayList<>();
        items.add(new DTOTransferEntity("1", new DTODestinationBalanceEvent("1")));
        items.add(new DTOTransferEntity("2", new DTODestinationBalanceEvent("2")));
        items.add(new DTOTransferEntity("3", new DTODestinationBalanceEvent("3")));
        items.add(new DTOTransferEntity("4", new DTODestinationBalanceEvent("4")));

        List<DTODestinationBalanceEvent> dtoDestinationBalanceEvents = items.parallelStream().map(DTOTransferEntity::getDestinationEvent).collect(Collectors.toList());
        dtoDestinationBalanceEvents.forEach(System.out::println);
    }

    @Test
    public void testSqlStrings() {
        List<String> tableNameList = new ArrayList<>(List.of("C_BR_PRTY_RLE_PSTL_ADDR",
                "C_BO_PSTL_ADDR",
                "C_BO_PRTY_RLE_TAX",
                "C_C_XO_PARTY_BANK",
                "C_C_XO_PARTY_ROLE",
                "C_C_XO_BUSINESS_CHANNEL",
                "C_C_XO_BUSINESS_SERVICES"
        ));

        String CREATE_TEMP_TABLE_QUERY = "SELECT ROWID_XREF INTO c360_ors.dbo.TEMP_{TABLE_NAME} FROM c360_ors.dbo.{TABLE_NAME}_XREF WHERE 0 = 1";
        String CLEAR_TEMP_TABLE_QUERY = "DELETE FROM c360_ors.dbo.TEMP_{TABLE_NAME};";
        String INITIAL_TEMP_QUERY = "IF OBJECT_ID('c360_ors.dbo.TEMP_{TABLE_NAME}', 'U') IS NULL ";

        if (tableNameList.iterator().hasNext()) {
            String tableName = tableNameList.iterator().next();
            String CREATE_TEMP_TABLE_QUERY_SQL = CREATE_TEMP_TABLE_QUERY.replace("{TABLE_NAME}", tableName)
                    .replace("{TABLE_NAME}", tableName);
            String CLEAR_TEMP_TABLE_QUERY_SQL = CLEAR_TEMP_TABLE_QUERY.replace("{TABLE_NAME}", tableName);
            String SQL_QUERY = INITIAL_TEMP_QUERY.replace("{TABLE_NAME}", tableName)
                    + CREATE_TEMP_TABLE_QUERY_SQL
                    + " ELSE " + CLEAR_TEMP_TABLE_QUERY_SQL;

            System.out.println(SQL_QUERY);

            String CONDITION_QUERY = "(SELECT ROWID_XREF FROM c360_ors.dbo.{TABLE_NAME}_XREF WHERE {CONDITION});";
            String INSERT_TEMP_QUERY = "INSERT INTO c360_ors.dbo.TEMP_{TABLE_NAME} (ROWID_XREF) ";
            CONDITION_QUERY = CONDITION_QUERY.replace("{CONDITION}", "HUB_STATE_IND = -1");

            SQL_QUERY = INSERT_TEMP_QUERY.replace("{TABLE_NAME}", tableName)
                    .concat(CONDITION_QUERY.replace("{TABLE_NAME}", tableName));

            System.out.println(SQL_QUERY);

            tableNameList.remove(tableName);
            System.out.println(tableNameList);
        }


    }
    public boolean isBlank(String str)
    {
        if (str == null)
        {
            return true;
        }
        int len = str.length();
        for (int i = 0; i < len; i++)
        {
            if (!Character.isWhitespace(str.codePointAt(i)))
            {
                // found a non-whitespace, we can stop searching  now
                return false;
            }
        }
        // only whitespace
        return true;
    }
    public boolean isNotBlank(String str)
    {
        if (str == null)
        {
            return false;
        }
        int len = str.length();
        for (int i = 0; i < len; i++)
        {
            if (!Character.isWhitespace(str.codePointAt(i)))
            {
                // found a non-whitespace, we can stop searching  now
                return true;
            }
        }
        // only whitespace
        return false;
    }
    @Test
    public void name() {


        String vatTaxType = "";
        if (true) {
            String vatId = "PL2220897045";
            String taxId = "";

            if (isNotBlank(vatId)) {
                vatTaxType = "VAT_TYPE";
            }

            if (isNotBlank(taxId) && isBlank(vatTaxType)) {
                vatTaxType = "TAX_TYPE";
            }

        }
        System.out.println(vatTaxType);
    }

    @Test
    public void testStringFormat() {
        String faultCode = "SIP-23141";
        String faultString = "Error with test code";
        String output = String.format("Received Fault message with code: %s, and value: %s. Detailed in logs", faultCode,
                faultString);

        System.out.println(output);
    }

    @Test
    public void testRegExp() {
        String dateConvertString = "CASE WHEN CHARINDEX('-', {DATE_COLUMN}) > 0 "
                + "THEN CONVERT(datetime, {DATE_COLUMN}, 103) "
                + "ELSE CAST({DATE_COLUMN} AS datetime) "
                + "END";
        dateConvertString = dateConvertString.replaceAll("\\{DATE_COLUMN}", "{PREFIX}_{SOURCE_SYSTEM}_LOAD_DATE");
        System.out.println(dateConvertString);
    }

    @Test
    public void testSpecialMultiply() {
        assertEquals(20, multiply(4, 5));
        assertEquals(-15, multiply(5, -3));
        assertEquals(-28, multiply(-7, 4));
        assertEquals(5, multiply(-1, -5));
        assertEquals(0, multiply(0, 0));
        assertEquals(0, multiply(1, 0));
        assertEquals(0, multiply(0, 2));
        assertEquals(0, multiply(-1, 0));
        assertEquals(0, multiply(0, -234));

    }

    @Test
    public void testEqualizeArray() {

        // [1, 2, 2, 3]
        // [3, 3, 1, 2, 3]
        // [1, 1, 1, 1]
        // [1, 2, 3, 4, 5]
        // [1, 1, 4, 2, 4, 4, 1, 1, 1, 2]
        // [3 3 2 1 1 3]
        // null
        // []
        // [0 -3 2 -1 1 3 1]
        List<Integer> inputArray = createIntegerArrayList("1 2 2 3");
        Assert.assertEquals(2, equalizeArray(inputArray));

        inputArray = createIntegerArrayList("3 3 1 2 3");
        Assert.assertEquals(2, equalizeArray(inputArray));

        inputArray = createIntegerArrayList("1 1 1 1");
        Assert.assertEquals(0, equalizeArray(inputArray));

        inputArray = createIntegerArrayList("1 2 3 4 5");
        Assert.assertEquals(4, equalizeArray(inputArray));

        inputArray = createIntegerArrayList("1 1 4 2 4 4 1 1 1 2");
        Assert.assertEquals(5, equalizeArray(inputArray));

        inputArray = createIntegerArrayList("3 3 2 1 1 3");
        Assert.assertEquals(3, equalizeArray(inputArray));

        Assert.assertEquals(0, equalizeArray(null));

        Assert.assertEquals(0, equalizeArray(Collections.emptyList()));

        inputArray = createIntegerArrayList("0 -3 2 -1 1 3 1");
        Assert.assertEquals(5, equalizeArray(inputArray));
    }

    @Test
    public void test123() {

        String previewPromoteResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ns6:LegalEntity xmlns:ns5=\"urn:co-types.informatica.mdm\" xmlns:ns0=\"urn:cs-rest.informatica.mdm\" xmlns:ns1=\"urn:cs-base.informatica.mdm\" xmlns:ns2=\"urn:co-base.informatica.mdm\" xmlns:ns6=\"urn:co-ors.informatica.mdm\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns6:LegalEntity\">   <ns6:LegalEntity label=\"prm_Prv1\">      <ns2:link href=\"/request/hm_icons/hierarchymanager/HospitalGroup/HospitalGroup_Small.png?ors={ors}\" rel=\"icon\"/>      <ns2:link href=\"/request/hm_icons/hierarchymanager/HospitalGroup/HospitalGroup_Small.png?ors={ors}\" rel=\"icon\"/>      <ns2:rowidObject>49032         </ns2:rowidObject>      <ns2:creator>thomas.reichvilser.external@zalando.de</ns2:creator>      <ns2:createDate>2022-06-29T16:19:51.159+02:00</ns2:createDate>      <ns2:updatedBy>admin</ns2:updatedBy>      <ns2:lastUpdateDate>2024-03-04T15:16:08.09+01:00</ns2:lastUpdateDate>      <ns2:consolidationInd>1</ns2:consolidationInd>      <ns2:lastRowidSystem>SAP           </ns2:lastRowidSystem>      <ns2:interactionId>199387229000</ns2:interactionId>      <ns2:hubStateInd>1</ns2:hubStateInd>      <ns6:Party_Type>Legal Entity</ns6:Party_Type>      <ns6:Party_Bus_Key>0004003669</ns6:Party_Bus_Key>      <ns6:VAT_TAX_ID>DE144837194</ns6:VAT_TAX_ID>      <ns6:LegalCountry>DE</ns6:LegalCountry>      <ns6:Name>prm_Prv1</ns6:Name>   </ns6:LegalEntity>   <ns6:changeSummary logging=\"false\" create=\"#/ns6:LegalEntity/ns6:LegalEntity/ns2:link[2]\" xmlns:sdo=\"commonj.sdo\">      <ns6:LegalEntity label=\"prm_Prv\" sdo:ref=\"#/ns6:LegalEntity/ns6:LegalEntity\">         <ns2:link sdo:ref=\"#/ns6:LegalEntity/ns6:LegalEntity/ns2:link[1]\"/>         <ns6:Name>prm_Prv</ns6:Name>         <ns6:KNumber>test_1</ns6:KNumber>      </ns6:LegalEntity>   </ns6:changeSummary></ns6:LegalEntity>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(previewPromoteResponse)));

            // Get the root element
            Element root = document.getDocumentElement();

            // Traverse the child nodes of the root
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                System.out.println(childNode.getNodeName());
                if (childNode.getNodeName().contains("changeSummary")) {
                    if (childNode.getTextContent() != null &&
                        childNode.getTextContent().trim().length() > 0) {
                        System.out.println(true);
                    }
                }
            }
            System.out.println(false);
        } catch (Exception e) {
            System.out.println(false);
            e.printStackTrace();
        }
    }
}
