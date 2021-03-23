import views.LeftPanel
import views.RightPanel
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class BuyWindow {
    private val window = JFrame("测试")
    private val leftPanel = LeftPanel()
    private val rightPanel by lazy { RightPanel() }

    fun init() {
        window.setSize(400, 200)
        window.layout = BorderLayout()
        window.add(leftPanel.getView(), BorderLayout.WEST)
        window.add(rightPanel.getView(), BorderLayout.CENTER)

        window.defaultCloseOperation = JFrame.EXIT_ON_CLOSE;
        window.pack();
        window.isVisible = true;
    }
}