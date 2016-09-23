# Bulutfon Android SDK

Bulutfon API'ye erişmek için Android SDK'sı. 

* [Dokümantasyon](https://github.com/bulutfon/documents/tree/master/API)

## Kullanım

```java
	public class MainActivity extends AppCompatActivity {
	    private Detail detail;
	    private ArrayList<Message> messages;
	    private ArrayList<MessageTitle> messageTitles;
	    private Message message;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        try {
	            BulutfonConfig config = new BulutfonConfig("MASTER TOKEN");
	            //BulutfonConfig config = new BulutfonConfig(AuthType.CREDENTIALS, "email", "password");
	            Bulutfon bulutfon = new Bulutfon(config);

	            //region USER DETAIL
	            bulutfon.userDetail().getDetail(new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    detail = new Detail(response);
	                }
	            });
	            detail = bulutfon.userDetail().getDetailSynched();
	            //endregion

	            //region MESSAGE TITLE
	            bulutfon.messageTitles().getMessageTitles(new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    messageTitles = MessageTitle.getMessageTitlesList(response);
	                }
	            });

	            messageTitles = bulutfon.messageTitles().getMessageTitlesSynched();
	            //endregion

	            //region GET MESSAGE LIST
	            RequestParams params = new RequestParams();
	            params.add("limit", "10");
	            bulutfon.messages().getMessages(params, new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    messages = Message.getMessagesList(response);
	                }
	            });

	            messages = bulutfon.messages().getMessagesSynched(null);
	            //endregion

	            //region MESSAGE DETAIL
	            bulutfon.messages().getMessage(27599, new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    try {
	                        message = new Message(response.getJSONObject("messages"));
	                    } catch (JSONException e) {
	                        e.printStackTrace();
	                    }
	                }
	            });

	            message = bulutfon.messages().getMessageSynched(27599);
	            //endregion

	            //region SEND MESSAGE
	            ArrayList<MessageRecipient> recipients = new ArrayList<>();
	            recipients.add(new MessageRecipient("908508850000"));
	            message = new Message("TITLE", "CONTENT", recipients);
	            bulutfon.messages().createMessage(message, new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    RequestResult result = new RequestResult(response);
	                }
	            });

	            RequestResult result = bulutfon.messages().createMessageSynched(message);
	            //endregion

	            //region GET CDR LIST
	            bulutfon.cdrs().getCdrs(null, new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    cdrs = Cdr.getCdrsList(response);
	                }
	            });

	            cdrs = bulutfon.cdrs().getCdrsSynched(null);
	            //endregion

	            //region GET CDR
	            bulutfon.cdrs().getCdr("UUID", new BulutfonHttpResponseHandler() {
	                @Override
	                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	                    cdr = new Cdr(response);
	                }
	            });

	            cdr = bulutfon.cdrs().getCdrSynched("UUID");
	            //endregion

	        } catch (BulutfonAuthException e) {
	            e.printStackTrace();
	            Log.e("Bulutfon Exception", "Bulutfon Auth EXCEPTION");
	        } catch (JSONException e) {
	            e.printStackTrace();
	            Log.e("Bulutfon Exception", "JSON EXCEPTION");
	        }
	    }
	}

```