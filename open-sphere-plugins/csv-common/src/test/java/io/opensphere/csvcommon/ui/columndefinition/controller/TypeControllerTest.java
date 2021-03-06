package io.opensphere.csvcommon.ui.columndefinition.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import io.opensphere.core.util.collections.New;
import io.opensphere.csvcommon.detect.ValueWithConfidence;
import io.opensphere.csvcommon.detect.ValuesWithConfidence;
import io.opensphere.csvcommon.detect.controller.DetectedParameters;
import io.opensphere.csvcommon.detect.location.model.LatLonColumnResults;
import io.opensphere.csvcommon.detect.location.model.LocationResults;
import io.opensphere.csvcommon.detect.location.model.PotentialLocationColumn;
import io.opensphere.csvcommon.ui.columndefinition.model.ColumnDefinitionModel;
import io.opensphere.csvcommon.ui.columndefinition.model.ColumnDefinitionRow;
import io.opensphere.importer.config.ColumnType;

/** Tests the TypeController class. */
public class TypeControllerTest
{
    /** The model used for datatype selection tests. */
    private ColumnDefinitionModel myModel;

    /** The type controller used for datatype selection tests. */
    @SuppressWarnings("unused")
    private TypeController myController;

    /** The selected column definition used for datatype selection tests. */
    private ColumnDefinitionRow mySelectedColumn;

    /** The unselected column definition used for datatype selection tests. */
    private ColumnDefinitionRow myUnselectedColumn;

    /** A setup method run before every test. */
    @Before
    public void setup()
    {
        myModel = new ColumnDefinitionModel();

        myController = new TypeController(myModel);

        mySelectedColumn = new ColumnDefinitionRow();
        mySelectedColumn.setColumnId(0);
        mySelectedColumn.setDataType(ColumnType.LOB.toString());

        myUnselectedColumn = new ColumnDefinitionRow();
        myUnselectedColumn.setColumnId(1);

        myModel.getDefinitionTableModel().addRows(New.list(mySelectedColumn, myUnselectedColumn));
    }

    /**
     * Tests the selection of an empty column, ensuring that the correct columns
     * are removed.
     */
    @Test
    public void testDataTypesSelectedEmpty()
    {
        myUnselectedColumn.setDataType("");
        myModel.setSelectedDefinition(mySelectedColumn);

        assertEquals(22, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a timestamp column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedTimestamp()
    {
        myUnselectedColumn.setDataType(ColumnType.TIMESTAMP.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.TIMESTAMP.toString()));
        assertEquals(22, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.TIME.toString()));
    }

    /**
     * Tests the selection of a DATE column, ensuring that the correct columns
     * are removed.
     */
    @Test
    public void testDataTypesSelectedDate()
    {
        myUnselectedColumn.setDataType(ColumnType.DATE.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DATE.toString()));
        assertEquals(23, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.TIMESTAMP.toString()));
    }

    /**
     * Tests the selection of a TIME column, ensuring that the correct columns
     * are removed.
     */
    @Test
    public void testDataTypesSelectedTime()
    {
        myUnselectedColumn.setDataType(ColumnType.TIME.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.TIME.toString()));
        assertEquals(23, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.TIMESTAMP.toString()));
    }

    /**
     * Tests the selection of a DOWN_TIMESTAMP column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedDownTimestamp()
    {
        myUnselectedColumn.setDataType(ColumnType.DOWN_TIMESTAMP.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertEquals(22, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a DOWN_DATE column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedDownDate()
    {
        myUnselectedColumn.setDataType(ColumnType.DOWN_DATE.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertEquals(22, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a DOWN_TIME column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedDownTime()
    {
        myUnselectedColumn.setDataType(ColumnType.DOWN_TIME.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
        assertEquals(22, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
    }

    /**
     * Tests the selection of a latitude column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedLatitude()
    {
        myUnselectedColumn.setDataType(ColumnType.LAT.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.LAT.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a longitude column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedLongitude()
    {
        myUnselectedColumn.setDataType(ColumnType.LON.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.LON.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of an MGRS column, ensuring that the correct columns
     * are removed.
     */
    @Test
    public void testDataTypesSelectedMgrs()
    {
        myUnselectedColumn.setDataType(ColumnType.MGRS.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.MGRS.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a position column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedPosition()
    {
        myUnselectedColumn.setDataType(ColumnType.POSITION.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.POSITION.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a WKT Geometry column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedWktGeometry()
    {
        myUnselectedColumn.setDataType(ColumnType.WKT_GEOMETRY.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.WKT_GEOMETRY.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a Semi-major column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedSemiMajor()
    {
        myUnselectedColumn.setDataType(ColumnType.SEMIMAJOR.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.SEMIMAJOR.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a Semi-minor column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedSemiMinor()
    {
        myUnselectedColumn.setDataType(ColumnType.SEMIMINOR.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.SEMIMINOR.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of an orientation column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedOrientation()
    {
        myUnselectedColumn.setDataType(ColumnType.ORIENTATION.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.ORIENTATION.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a radius column, ensuring that the correct columns
     * are removed.
     */
    @Test
    public void testDataTypesSelectedRadius()
    {
        myUnselectedColumn.setDataType(ColumnType.RADIUS.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.RADIUS.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of a line-of-bearing column, ensuring that the
     * correct columns are removed.
     */
    @Test
    public void testDataTypesSelectedLineOfBearing()
    {
        myUnselectedColumn.setDataType(ColumnType.LOB.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.LOB.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Tests the selection of an altitude column, ensuring that the correct
     * columns are removed.
     */
    @Test
    public void testDataTypesSelectedAltitude()
    {
        myUnselectedColumn.setDataType(ColumnType.ALT.toString());
        myModel.setSelectedDefinition(mySelectedColumn);

        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.ALT.toString()));
        assertEquals(21, myModel.getAvailableDataTypes().size());

        // ensure that the myModel does not contain unexpected columns:
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIMESTAMP.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_DATE.toString()));
        assertFalse(myModel.getAvailableDataTypes().contains(ColumnType.DOWN_TIME.toString()));
    }

    /**
     * Verifies that all available data types are populated when no other
     * columns have a selected data type.
     */
    @Test
    public void testNoDataTypesSelected()
    {
        final ColumnDefinitionModel model = new ColumnDefinitionModel();

        @SuppressWarnings("unused")
        final TypeController controller = new TypeController(model);

        final ColumnDefinitionRow selectedColumn = new ColumnDefinitionRow();
        selectedColumn.setColumnId(0);
        selectedColumn.setColumnName("Test Column");
        selectedColumn.setDataType(ColumnType.TIMESTAMP.toString());

        model.getDefinitionTableModel().addRows(New.list(selectedColumn));
        model.setSelectedDefinition(selectedColumn);

        assertEquals("", model.getAvailableDataTypes().get(0));
        assertEquals(ColumnType.ALT.toString(), model.getAvailableDataTypes().get(1));
        assertEquals(ColumnType.DATE.toString(), model.getAvailableDataTypes().get(2));
        assertEquals(ColumnType.TIME.toString(), model.getAvailableDataTypes().get(3));
        assertEquals(ColumnType.TIMESTAMP.toString(), model.getAvailableDataTypes().get(4));
        assertEquals(ColumnType.LAT.toString(), model.getAvailableDataTypes().get(5));
        assertEquals(ColumnType.LOB.toString(), model.getAvailableDataTypes().get(6));
        assertEquals(ColumnType.LON.toString(), model.getAvailableDataTypes().get(7));
        assertEquals(ColumnType.MGRS.toString(), model.getAvailableDataTypes().get(8));
        assertEquals(ColumnType.ORIENTATION.toString(), model.getAvailableDataTypes().get(9));
        assertEquals(ColumnType.OTHER.toString(), model.getAvailableDataTypes().get(10));
        assertEquals(ColumnType.POSITION.toString(), model.getAvailableDataTypes().get(11));
        assertEquals(ColumnType.RADIUS.toString(), model.getAvailableDataTypes().get(12));
        assertEquals(ColumnType.SEMIMAJOR.toString(), model.getAvailableDataTypes().get(13));
        assertEquals(ColumnType.SEMIMINOR.toString(), model.getAvailableDataTypes().get(14));
        assertEquals(ColumnType.WKT_GEOMETRY.toString(), model.getAvailableDataTypes().get(15));
        assertEquals(ColumnType.ASSOCIATION_ID.toString(), model.getAvailableDataTypes().get(16));
        assertEquals(ColumnType.HEADING.toString(), model.getAvailableDataTypes().get(17));
        assertEquals(ColumnType.HEADING_ERROR.toString(), model.getAvailableDataTypes().get(18));
        assertEquals(ColumnType.SPEED.toString(), model.getAvailableDataTypes().get(19));
        assertEquals(ColumnType.SPEED_ERROR.toString(), model.getAvailableDataTypes().get(20));
        assertEquals(ColumnType.COLOR.toString(), model.getAvailableDataTypes().get(21));

        model.setSelectedDefinition(null);

        int index = 0;
        assertEquals("", model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.ALT.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.DOWN_DATE.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.DOWN_TIME.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.DOWN_TIMESTAMP.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.LAT.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.LOB.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.LON.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.MGRS.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.ORIENTATION.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.OTHER.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.POSITION.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.RADIUS.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.SEMIMAJOR.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.SEMIMINOR.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.WKT_GEOMETRY.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.ASSOCIATION_ID.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.HEADING.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.HEADING_ERROR.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.SPEED.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.SPEED_ERROR.toString(), model.getAvailableDataTypes().get(index++));
        assertEquals(ColumnType.COLOR.toString(), model.getAvailableDataTypes().get(index++));
    }

    /**
     * Verifies that when a column is a probable location, the location types
     * are first in the available types list.
     */
    @Test
    public void testProbableLocation()
    {
        final LatLonColumnResults latLonResults = new LatLonColumnResults(
                new PotentialLocationColumn("column0", ColumnType.LAT, "", "", false, 0),
                new PotentialLocationColumn("column1", ColumnType.LON, "", "", false, 1));
        latLonResults.setConfidence(90);

        final LocationResults results = new LocationResults();
        results.addResult(latLonResults);

        final PotentialLocationColumn locationColumn = new PotentialLocationColumn("column2", ColumnType.MGRS, "", "", false, 2);
        locationColumn.setConfidence(90f);
        results.addResult(locationColumn);

        final ValueWithConfidence<LocationResults> locationConfidence = new ValueWithConfidence<>();
        locationConfidence.setValue(results);

        final ValuesWithConfidence<LocationResults> locationConfidences = new ValuesWithConfidence<>();
        locationConfidences.add(locationConfidence);

        final DetectedParameters detected = new DetectedParameters();
        detected.setLocationParameter(locationConfidences);

        final ColumnDefinitionModel model = new ColumnDefinitionModel();
        model.setDetectedParameters(detected);

        final ColumnDefinitionRow column0 = new ColumnDefinitionRow();
        column0.setColumnId(0);

        final ColumnDefinitionRow column1 = new ColumnDefinitionRow();
        column1.setColumnId(1);

        final ColumnDefinitionRow column2 = new ColumnDefinitionRow();
        column2.setColumnId(2);

        final ColumnDefinitionRow column3 = new ColumnDefinitionRow();
        column3.setColumnId(3);

        final ColumnDefinitionRow column4 = new ColumnDefinitionRow();
        column4.setColumnId(4);

        @SuppressWarnings("unused")
        final TypeController controller = new TypeController(model);

        model.setSelectedDefinition(column0);
        assertEquals("", model.getAvailableDataTypes().get(0));
        assertEquals(ColumnType.LAT.toString(), model.getAvailableDataTypes().get(1));

        model.setSelectedDefinition(column1);
        assertEquals("", model.getAvailableDataTypes().get(0));
        assertEquals(ColumnType.LON.toString(), model.getAvailableDataTypes().get(2));

        model.setSelectedDefinition(column2);
        assertEquals("", model.getAvailableDataTypes().get(0));
        assertEquals(ColumnType.MGRS.toString(), model.getAvailableDataTypes().get(3));

        model.setSelectedDefinition(column3);
        assertEquals("", model.getAvailableDataTypes().get(0));
        assertEquals(ColumnType.ALT.toString(), model.getAvailableDataTypes().get(1));

        model.setSelectedDefinition(column4);
        assertEquals("", model.getAvailableDataTypes().get(0));
        assertEquals(ColumnType.TIMESTAMP.toString(), model.getAvailableDataTypes().get(4));
    }
}
