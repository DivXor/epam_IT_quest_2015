package kz.epam.quiz.entity.enums;

public enum TaskTypeEnum {

    GRAMMAR("Grammar quiz"),
    FIND_EXCESS("Find excess image"),
    WORD_SEARCH("Word search"),
    MAZE("Maze"),
    ASSOCIATIONS("Associations"),
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

