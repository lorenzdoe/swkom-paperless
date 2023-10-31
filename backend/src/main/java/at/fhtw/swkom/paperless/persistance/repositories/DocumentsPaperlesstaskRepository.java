package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.DocumentsPaperlesstask;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class DocumentsPaperlesstaskRepository implements JpaRepository<DocumentsPaperlesstask, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends DocumentsPaperlesstask> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<DocumentsPaperlesstask> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DocumentsPaperlesstask getOne(Long aLong) {
        return null;
    }

    @Override
    public DocumentsPaperlesstask getById(Long aLong) {
        return null;
    }

    @Override
    public DocumentsPaperlesstask getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DocumentsPaperlesstask> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DocumentsPaperlesstask> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends DocumentsPaperlesstask, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DocumentsPaperlesstask> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DocumentsPaperlesstask> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<DocumentsPaperlesstask> findAll() {
        return null;
    }

    @Override
    public List<DocumentsPaperlesstask> findAllById(Iterable<Long> longs) {
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
    public void delete(DocumentsPaperlesstask entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends DocumentsPaperlesstask> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<DocumentsPaperlesstask> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DocumentsPaperlesstask> findAll(Pageable pageable) {
        return null;
    }
}
