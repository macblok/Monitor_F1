package channels;

public class ChannelHighlights implements IChannel {

	private String name;
	private String news;

	public ChannelHighlights() {
		this.name = "highlights";
		this.news = "";
	}

	@Override
	public void updateNews(String update) {
		if (!update.equals(news)) {
			news = update;
			sellNews();
		}
	}

	@Override
	public void sellNews() {
		ChannelManager manager = ChannelManager.getInstance();
		manager.notifyNews(this, news);

	}

	public String getChannelName() {
		return name;
	}
	
}
