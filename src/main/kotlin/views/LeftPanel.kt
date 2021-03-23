package views

import java.awt.Color
import java.awt.Component
import javax.swing.*

class LeftPanel {
    private val settingLabel = JLabel("设置")
    private val serverTimeLabel = JLabel("服务器时间")
    private val perRequestTimeLabel = JLabel("一次请求时间")
    private val localTimeLabel = JLabel("本地时间")
    private val preTimeLabel = JLabel("提前时间")
    private val preTimeTextField = JTextField(5)
    private val openBrowserLabel = JLabel("开启浏览器模拟")
    private val openBrowserCheckBox = JCheckBox()
    private val startButton = JButton("开始")
    private val group = JPanel()

    init {
        group.border = BorderFactory.createTitledBorder("设置")
        val vLayout = Box.createVerticalBox()

        vLayout.add(Box.createVerticalStrut(30))
        vLayout.add(serverTimeLabel)
        vLayout.add(Box.createVerticalStrut(10))
        vLayout.add(perRequestTimeLabel)
        vLayout.add(Box.createVerticalStrut(10))
        vLayout.add(localTimeLabel)
        vLayout.add(Box.createVerticalStrut(5))

        val preTimeGroup = Box.createHorizontalBox()
        preTimeGroup.add(preTimeLabel)
        preTimeGroup.add(preTimeTextField)
        preTimeGroup.alignmentX = Component.LEFT_ALIGNMENT
        vLayout.add(preTimeGroup)
        vLayout.add(Box.createVerticalStrut(5))

        val openBrowserPanel = Box.createHorizontalBox()
        openBrowserPanel.add(openBrowserLabel)
        openBrowserPanel.add(openBrowserCheckBox)
        openBrowserPanel.alignmentX = Component.LEFT_ALIGNMENT
        vLayout.add(openBrowserPanel)
        vLayout.add(Box.createVerticalStrut(5))

        val startPanel = JPanel()
        startPanel.add(startButton)
        vLayout.add(startPanel)
        startPanel.alignmentX = Component.LEFT_ALIGNMENT
        group.add(vLayout)
    }

    fun getView(): Component {
        return group
    }
}