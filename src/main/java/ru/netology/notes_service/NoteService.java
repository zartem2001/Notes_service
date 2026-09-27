package ru.netology.notes_service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public Note create(Note note) {
        note.setId(null); // защита от подмены id из тела запроса
        return noteRepository.save(note);
    }

    @Transactional(readOnly = true)
    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Заметка с id " + id + " не найдена"));
    }

    @Transactional(readOnly = true)
    public List<Note> getAll(String query) {
        if (query != null && !query.isBlank()) {
            return noteRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(query, query);
        }
        return noteRepository.findAll();
    }

    @Transactional
    public Note update(Long id, Note updatedNote) {
        Note existing = getById(id);
        existing.setTitle(updatedNote.getTitle());
        existing.setContent(updatedNote.getContent());
        return noteRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new EntityNotFoundException("Заметка с id " + id + " не найдена");
        }
        noteRepository.deleteById(id);
    }
}
