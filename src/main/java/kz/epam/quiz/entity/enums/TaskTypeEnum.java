package kz.epam.quiz.entity.enums;

public enum TaskTypeEnum {

    MAZE("Maze"),
    ASSOCIATIONS("Associations"),
    WORD_SEARCH("Word search"),
    GRAMMAR("Grammar quiz"),
    FIND_SUPERFLUOUS("Find excess image"),
    FINISH("Finish");

    private final String name;

    TaskTypeEnum(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return otherName != null && name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

