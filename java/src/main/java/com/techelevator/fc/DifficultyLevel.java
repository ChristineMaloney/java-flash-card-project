package com.techelevator.fc;

    public enum DifficultyLevel {
        BASIC("The easy stuff"),
        MEDIUM("A little harder stuff"),
        ADVANCED("The hardest stuff");

        private String definition;

        private DifficultyLevel(String definition){
            this.definition=definition;
        }

        public String getDefinition(){
            return definition;
        }
    }
