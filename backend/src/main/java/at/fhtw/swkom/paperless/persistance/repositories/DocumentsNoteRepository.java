package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsNote;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsNoteRepository implements JpaRepository<DocumentsNote, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsNote> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsNote> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsNote getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsNote getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsNote getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsNote> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsNote> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsNote, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsNote> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsNote> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsNote> findAll() {
        return null;
    }

    @Override
    public List<DocumentsNote> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DocumentsNote entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsNote> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsNote> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsNote> findAll(Pageable pageable) {
        return null;
    }
}
