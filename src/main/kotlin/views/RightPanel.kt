package views

import java.awt.*
import javax.swing.table.DefaultTableModel
import javax.swing.table.TableCellRenderer

import javax.swing.*


class RightPanel {
    private var model = RowDataModel()
    private var table: JTable = object : JTable(model) {
        private val evenColor: Color = Color(0xDDDDDD)
        override fun prepareRenderer(tcr: TableCellRenderer, row: Int, column: Int): Component {
            val c: Component = super.prepareRenderer(tcr, row, column)
            if (isRowSelected(row)) {
                c.foreground = getSelectionForeground()
                c.background = getSelectionBackground()
            } else {
                c.foreground = foreground
//                c.background = if (row % 2 == 0) evenColor else background
                c.background = evenColor
            }
            return c
        }
    }
    private val addButton = JButton("+")
    private val deleteButton = JButton("-")
    private val root = JPanel()


    fun getView(): Component {
        table.autoCreateRowSorter = true
        table.fillsViewportHeight = true
        root.layout = BorderLayout()
        root.add(JScrollPane(table))

        val operationPanel = JPanel(FlowLayout(FlowLayout.LEFT, 10, 0))
        operationPanel.background = Color.WHITE
        addButton.isContentAreaFilled = false
        deleteButton.isContentAreaFilled = false
        operationPanel.add(addButton)
        operationPanel.add(deleteButton)
        operationPanel.border = BorderFactory.createTitledBorder("")
        root.add(operationPanel, BorderLayout.SOUTH)

        addButton.addActionListener {
            model.addRowData(RowData())
            val rect = table.getCellRect(model.rowCount - 1, 0, true)
            table.scrollRectToVisible(rect)
        }

        deleteButton.addActionListener {
            val selectionRows = table.selectedRows
            for (row in selectionRows) {
                model.removeRow(table.convertRowIndexToModel(row))
            }
        }
        return root
    }

    class RowDataModel : DefaultTableModel() {
        private val number = 0
        fun addRowData(t: RowData) {
            val obj = arrayOf<Any>(t.link, t.name, t.time, t.result, t.note)
            super.addRow(obj)
            number
        }

        override fun isCellEditable(row: Int, col: Int): Boolean {
            return COLUMN_ARRAY[col].isEditable
        }

        override fun getColumnClass(column: Int): Class<*> {
            return COLUMN_ARRAY[column].columnClass
        }

        override fun getColumnCount(): Int {
            return COLUMN_ARRAY.size
        }

        override fun getColumnName(column: Int): String {
            return COLUMN_ARRAY[column].columnName
        }

        private class ColumnContext(val columnName: String, val columnClass: Class<*>, val isEditable: Boolean)
        companion object {
            private val COLUMN_ARRAY = arrayOf(
                ColumnContext("链接", String::class.java, true),
                ColumnContext("名称", String::class.java, true),
                ColumnContext("开抢时间", String::class.java, false),
                ColumnContext("结果", String::class.java, false),
                ColumnContext("备注", String::class.java, true)
            )
        }
    }

    //    internal class RowData protected constructor(var name: String, var comment: String)
    data class RowData(
        var link: String = "",
        var name: String = "",
        var time: String = "",
        var result: String = "",
        var note: String = ""
    )
}