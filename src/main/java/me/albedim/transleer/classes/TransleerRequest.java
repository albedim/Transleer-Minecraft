package me.albedim.transleer.classes;

public class TransleerRequest {

        private String text;
        private String language;
        private String api_key;

        public TransleerRequest(String message, String language) {
            this.text = message;
            this.language = language;
            this.api_key = "mhdjeyd63jdh37dh";
        }

        public String getMessage() {
            return text;
        }

        public String getLanguage() {
            return language;
        }

}
