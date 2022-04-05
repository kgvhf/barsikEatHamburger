package mi.barsik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DocumentController implements Initializable {

    @FXML
    private TableColumn<Document, Boolean> actual;

    @FXML
    private TableColumn<Document, LocalDate> date_create;

    @FXML
    private TableColumn<Document, LocalDate> date_modify;

    @FXML
    private TableView<Document> documents;

    @FXML
    private TableColumn<Document, Integer> id;

    @FXML
    private TableColumn<Document, Integer> num;

    ObservableList<Document> list = FXCollections.observableArrayList(parse(getDocuments()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Document, Integer>("id"));
        num.setCellValueFactory(new PropertyValueFactory<Document, Integer>("num"));
        date_create.setCellValueFactory(new PropertyValueFactory<Document, LocalDate>("dateCreate"));
        date_modify.setCellValueFactory(new PropertyValueFactory<Document, LocalDate>("dateModify"));
        actual.setCellValueFactory(new PropertyValueFactory<Document, Boolean>("actual"));

        documents.setItems(list);
    }

    /**
     * @todo вытащить в сервис
     * Парсим Json
     *
     * @param jsonArray
     * @return
     */
    private List<Document> parse(JSONArray jsonArray) {
        List<Document> docs = new ArrayList<>();

        for (Object o : getDocuments().toArray()) {
            JSONObject jo = (JSONObject) o;
            docs.add(
                    new Document(
                            Integer.parseInt(jo.get("id").toString()),
                            Integer.parseInt(jo.get("num").toString()),
                            LocalDate.parse(jo.get("dateCreate").toString()),
                            LocalDate.parse(jo.get("dateModify").toString()),
                            Boolean.valueOf(jo.get("timely").toString())
                    )
            );
        }

        return docs;
    }

    /**
     * @todo вытащить в сервис
     * Получаем докуметы
     *
     * @return
     */
    private JSONArray getDocuments() {
        OkHttpClient client = new OkHttpClient();
        Request r = new Request.Builder()
                .url("http://localhost:8189/hamburger/api/documents").build();

        JSONParser parser = new JSONParser();

        try {
            Response response = client.newCall(r).execute();

            return (JSONArray) parser.parse(response.body().string());
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("An unknown error occurred");
        }

    }
}