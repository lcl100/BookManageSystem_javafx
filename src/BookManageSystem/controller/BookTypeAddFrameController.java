package BookManageSystem.controller;

import BookManageSystem.dao.BookTypeDao;
import BookManageSystem.tools.SimpleTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BookTypeAddFrameController {
    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private TextField bookTypeNameTextField;

    @FXML
    private Button addButton;

    @FXML
    private TextArea bookTypeDescriptionTextArea;

    @FXML
    private Button resetButton;

    public void initialize() {
        // 初始化按钮的图标
        simpleTools.setLabeledImage(new Labeled[]{addButton, resetButton}, new String[]{"src/BookManageSystem/images/add.png",
                "src/BookManageSystem/images/reset.png"});
    }

    // “添加”按钮的事件监听器方法
    public void do_addButton_event(ActionEvent event) {
        // 获取图书类别名称
        String bookTypeName = bookTypeNameTextField.getText();
        // 获取图书类别描述
        String bookTypeDescription = bookTypeDescriptionTextArea.getText();
        // 组装插入SQL语句
        String sql =
                "insert into tb_bookType (btName, btDescription) values ('" + bookTypeName + "','" + bookTypeDescription + "');";
        // 执行添加操作并返回操作结果
        boolean isOK = new BookTypeDao().dataChange(sql);
        // 对操作结果进行判断
        if (isOK) {
            // 添加成功则弹出提示框并清空文本框内容
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "添加成功！");
            bookTypeNameTextField.setText("");
            bookTypeDescriptionTextArea.setText("");
        } else {
            // 添加失败则弹出提示框
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "添加失败！");
        }
    }

    // “重置”按钮的事件监听器方法
    public void do_resetButton_event(ActionEvent event) {
        // 重置即清空用户输入的内容
        simpleTools.clearTextField(bookTypeNameTextField, bookTypeDescriptionTextArea);
    }
}
