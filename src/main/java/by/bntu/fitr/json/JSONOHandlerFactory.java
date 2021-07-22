package by.bntu.fitr.json;

import by.bntu.fitr.model.CommentWrapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JSONOHandlerFactory {

    public static JSONObjectHandler<CommentWrapper> commentJsonObjectHandler = new JSONObjectHandler<CommentWrapper>() {
        @Override
        public JSONObject objectHandle(CommentWrapper object) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userName", object.getUserName());
            jsonObject.put("email", object.getEmail());
            jsonObject.put("text", object.getText());
            jsonObject.put("date", object.getCreated());
            jsonObject.put("accountId",object.getAccountId());
            return jsonObject;
        }
    };

    public static <T> JSONArray getJsonArray(JSONObjectHandler<T> jsonObjectHandler,List<T> object){
        JSONArray jsonArray = new JSONArray();
        for(int i =0;i<object.size();i++){
            jsonArray.put(jsonObjectHandler.objectHandle(object.get(i)));
        }
        return jsonArray;
    }
/*
    public static <T> String JSONHandle(JSONArrayHandler<T> jsonArrayHandler, List<T> object) {
        return jsonArrayHandler.arrayHandle(object).toString();
    }


 */
}
