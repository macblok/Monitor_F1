package main;

import java.util.Scanner;

import channels.*;
import subscribers.*;

public class F1MonitorDemo {

	public F1MonitorDemo() {
	}

	public static void main(String[] args) {

		Subscriber me = new Subscriber();

		ChannelManager manager = ChannelManager.getInstance();

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.println("Welcom to F1 Monitor application! \n" + "\n" + "Choose channel to subscribe/unsubscribe: \n"
				+ "1 - Subscribe Live Channel \n" + "2 - Subscribe Highlights Channel \n"
				+ "3 - Unsubscribe Live Channel \n" + "4 - Unsubscribe Highlights Channel \n"
				+ "0 - Exit application \n" + "8 - Channel Live update \n" + "9 - Channel Highlights update");

		int tempLiveUpdate = 1000;
		int tempHighlightsUpdate = 1000;

		while ((input = scan.nextInt()) != 0) {

			switch (input) {

			case 1 -> {
				manager.subscribe(ChannelManager.live, me);
				System.out.println("Successfuly subscribed to Channel Live!");
			}
			case 2 -> {
				manager.subscribe(ChannelManager.highlights, me);
				System.out.println("Successfuly subscribed to Channel Highlights!");
			}
			case 3 -> {
				manager.unsubscribe(ChannelManager.live, me);
				System.out.println("Successfuly unsubscribed of Channel Live!");
			}
			case 4 -> {
				manager.unsubscribe(ChannelManager.highlights, me);
				System.out.println("Successfuly unsubscribed of Channel Highlights!");
			}
			case 0 -> {
				System.exit(-1);
			}
			default -> {
				System.out.println("Wrong selection");
			}

			case 8 -> {
				ChannelManager.live.updateNews(String.valueOf(tempLiveUpdate));
				tempLiveUpdate++;
			}
			case 9 -> {
				ChannelManager.highlights.updateNews(String.valueOf(tempHighlightsUpdate));
				tempHighlightsUpdate++;
			}

			}

		}
		System.out.println("Thank you for using F1 Monitor application!");
		scan.close();
	}

}
