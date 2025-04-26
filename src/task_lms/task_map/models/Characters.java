package task_lms.task_map.models;

import task_lms.task_map.enums.KeyCharacter;

import java.util.List;
import java.util.Map;

public class Characters {
    private Long id;
    private Map<KeyCharacter, List<String>> characteristics;

    public Characters() {
    }

    public Characters(Long id, Map<KeyCharacter, List<String>> characteristics) {
        this.id = id;
        this.characteristics = characteristics;
    }

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<KeyCharacter, List<String>> characteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<KeyCharacter, List<String>> characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "id=" + id +
                ", characteristics=" + characteristics +
                '}';
    }
}
