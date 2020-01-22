package fr.projet5;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *This class is used to create a table containing a number of column depending of the length of the header
 * (each header element is a column's name)
 */
public class ModeleStatic extends AbstractTableModel {
    private final List<ITable> tableValues = new ArrayList<>();
    String[] header;


    /**
     * ModeleStatic constructor, need a list of String to name each column, and this will defined how much column
     * we've got
     * @param header    String[] : the header content (list of all the string to name each column)
     */
    public ModeleStatic(String[] header){
        super();
        this.header=header;
    }


    /**
     * This method get the number of rows
     * @return  int : number of rows
     */
    public int getRowCount() {
        return tableValues.size();
    }


    /**
     * This method get the number of column
     * @return  int : number of columns
     */
    public int getColumnCount() {
        return header.length;
    }


    /**
     * This method get the columnName depending of the index given in parameter
     * @param columnIndex   int : column index (start at 0)
     * @return              String : the column name
     */
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }


    /**
     * This method get the value of a cell at a defined position by is row index and column index
     * @param rowIndex      int : row index (start at 0)
     * @param columnIndex   int : column index (start at 0)
     * @return              Object : the value of the cell
     */
    public Object getValueAt(int rowIndex, int columnIndex) {

        for(int i=0; i<this.getColumnCount();i++){
            if(columnIndex==i){
                    return tableValues.get(rowIndex).getListValues().get(i);
            }
        }
        return null;
    }


    /**
     * This method is used to add a line containing information into a table
     * @param tableInformation     ITable : table containing some information
     */
    public void addInformation(ITable tableInformation) {
        tableValues.add(tableInformation);
        fireTableRowsInserted(tableValues.size() -1, tableValues.size() -1);
    }


}