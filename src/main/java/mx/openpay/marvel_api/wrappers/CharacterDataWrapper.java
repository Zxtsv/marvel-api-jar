package mx.openpay.marvel_api.wrappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDataWrapper {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;
    private CharacterDataContainer data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CharacterDataContainer {
        private int offset;
        private int limit;
        private int total;
        private int count;
        private Character[] results;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Character {
            private int id;
            private String name;
            private String description;
            private String modified;
            private Thumbnail thumbnail;
            private ComicList comics;
            private SeriesList series;
            private StoryList stories;
            private EventList events;
            private Url[] urls;

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Thumbnail {
                private String path;
                private String extension;
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ComicList {
                private int available;
                private String collectionURI;
                private ComicSummary[] items;

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class ComicSummary {
                    private String resourceURI;
                    private String name;
                }
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class SeriesList {
                private int available;
                private String collectionURI;
                private SeriesSummary[] items;

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class SeriesSummary {
                    private String resourceURI;
                    private String name;
                }
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class StoryList {
                private int available;
                private String collectionURI;
                private StorySummary[] items;

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class StorySummary {
                    private String resourceURI;
                    private String name;
                    private String type;
                }
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class EventList {
                private int available;
                private String collectionURI;
                private EventSummary[] items;

                @Data
                @JsonIgnoreProperties(ignoreUnknown = true)
                public static class EventSummary {
                    private String resourceURI;
                    private String name;
                }
            }

            @Data
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Url {
                private String type;
                private String url;
            }
        }
    }
}