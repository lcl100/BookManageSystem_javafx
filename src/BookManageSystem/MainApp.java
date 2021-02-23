package BookManageSystem;

import BookManageSystem.controller.LogupFrameController;
import BookManageSystem.controller.SoftInformationFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("图书馆管理系统 ");
        // 启动界面即为登录界面
        initLogupFrame();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 登录界面
     */
    public void initLogupFrame() {
        try {
            // 加载登录界面的fxml文件
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/logupFrame.fxml"));
            AnchorPane root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("登录");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);

            // 获取登录界面的控制器类
            LogupFrameController controller = loader.getController();
            // 将stage作为参数传递到控制器中
            controller.setStage(primaryStage);

            // 展示舞台
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 主界面
     */
    public void initMainFrame() {
        try {
            // 加载主界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/mainFrame.fxml"));
            AnchorPane root = loader.load();

            // 设置stage舞台的属性
            Stage mainFrameStage = new Stage();
            mainFrameStage.setTitle("图书管理系统主界面");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);

            Scene scene = new Scene(root);
            mainFrameStage.setScene(scene);

            mainFrameStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图书类别添加界面
     *
     * @return 返回一个AnchorPane便于其他控件调用
     */
    public AnchorPane initBookTypeAddFrame() {
        try {
            // 加载FXML布局文件
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/bookTypeAddFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图书类别维护界面
     * @return 返回一个AnchorPane便于其他控件调用
     */
    public AnchorPane initBookTypeManageFrame() {
        try {
            // 加载图书类别维护界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/bookTypeManageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图书添加界面
     * @return 返回一个AnchorPane便于其他控件调用
     */
    public AnchorPane initBookAddFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/bookAddFrame.fxml"));
            AnchorPane pane = loader.load();
            return pane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图书维护界面
     * @return 返回一个AnchorPane便于其他控件调用
     */
    public AnchorPane initBookManageFrame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/bookManageFrame.fxml"));
            AnchorPane root = loader.load();
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关于软件弹出框界面
     * @return 返回Scene
     */
    public Scene initAboutSoftFrame() {
        try {
            // 加载关于软件界面
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/softInformationFrame.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage mainFrameStage = new Stage();
            mainFrameStage.setTitle("关于软件");
            mainFrameStage.setResizable(true);
            mainFrameStage.setAlwaysOnTop(false);
            mainFrameStage.initModality(Modality.APPLICATION_MODAL);
            mainFrameStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            mainFrameStage.setScene(scene);

            SoftInformationFrameController controller = loader.getController();
            controller.setDialogStage(mainFrameStage);

            mainFrameStage.showAndWait();
            return scene;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
