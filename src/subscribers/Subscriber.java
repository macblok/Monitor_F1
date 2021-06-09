package subscribers;

import channels.IChannel;

public class Subscriber implements IChannelSubscriber {

	public Subscriber() {
	}

	public void writeNews(IChannel channel, String news) {
		System.out.println(channel.getChannelName() + ": " + news);

	}

}
