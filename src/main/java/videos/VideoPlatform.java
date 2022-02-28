package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path) {
        List<String> output = new ArrayList<>();
        try {
            output = Files.readAllLines(path);
            System.out.println(output);
            String[] temp;

            for (int i = 1; i < output.size(); i++) {
                temp = output.get(i).split(";");
                String name = temp[0];
                int subscribers = Integer.parseInt(temp[1]);
                int videos = Integer.parseInt(temp[2]);
                Channel channel = new Channel(name, subscribers, videos);
                channels.add(channel);
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream().mapToInt(v -> v.getVideosUploaded()).sum();
    }
}
