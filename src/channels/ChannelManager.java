package channels;

import java.util.ArrayList;
import java.util.HashMap;

import subscribers.IChannelSubscriber;

public class ChannelManager {

	private ArrayList<IChannelSubscriber> liveSubscribers;
	private ArrayList<IChannelSubscriber> highlightsSubscribers;

	public static IChannel live;
	public static IChannel highlights;

	private static ChannelManager instance;
	private HashMap<IChannel, ArrayList<IChannelSubscriber>> subscribers = new HashMap<>();

	public ChannelManager() {
		liveSubscribers = new ArrayList<>();
		highlightsSubscribers = new ArrayList<>();

		live = new ChannelLive();
		highlights = new ChannelHighlights();

		subscribers.put(live, liveSubscribers);
		subscribers.put(highlights, highlightsSubscribers);

	}

	public static ChannelManager getInstance() { // Singleton, pilnujemy aby nie by³o wiêcej ni¿ 1 instancja
		if (instance == null) {
			instance = new ChannelManager();
		}

		return instance;

	}

	public void subscribe(IChannel channel, IChannelSubscriber subscriber) {
		subscribers.get(channel).add(subscriber);
	}

	public void unsubscribe(IChannel channel, IChannelSubscriber subscriber) {
		subscribers.get(channel).remove(subscriber);
	}

	public void notifyNews(IChannel channel, String news) {
		for (IChannelSubscriber subscriber : subscribers.get(channel)) {
			subscriber.writeNews(channel, news);
		}
	}

}
