package date.me.com.cn.model;

import javafx.fxml.Initializable;
import javafx.scene.Scene;

/**
 * Created by shj on 17-3-15.
 */
public class PageController {
    private Scene scene;
    private Initializable initializable;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageController that = (PageController) o;

        if (scene != null ? !scene.equals(that.scene) : that.scene != null) return false;
        return initializable != null ? initializable.equals(that.initializable) : that.initializable == null;

    }

    @Override
    public int hashCode() {
        int result = scene != null ? scene.hashCode() : 0;
        result = 31 * result + (initializable != null ? initializable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageController{" +
                "scene=" + scene +
                ", initializable=" + initializable +
                '}';
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Initializable getInitializable() {
        return initializable;
    }

    public void setInitializable(Initializable initializable) {
        this.initializable = initializable;
    }
}
