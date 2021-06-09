package channels;

public class ChannelLive implements IChannel {

	private String name;
	private String news;

	public ChannelLive() {
		this.name = "live";
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
