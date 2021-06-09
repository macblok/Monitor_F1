package subscribers;

import channels.IChannel;

public interface IChannelSubscriber {
	
	public void writeNews(IChannel channel, String news);
	
}
