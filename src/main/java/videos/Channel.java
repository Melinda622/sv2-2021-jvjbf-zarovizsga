package videos;

public class Channel {

    private String channelName;
    private int numberOfSubscribers;
    private int videosUploaded;

    public Channel(String channelName, int numberOfSubscribers, int videosUploaded) {
        this.channelName = channelName;
        this.numberOfSubscribers = numberOfSubscribers;
        this.videosUploaded = videosUploaded;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers;
    }

    public int getVideosUploaded() {
        return videosUploaded;
    }
}
