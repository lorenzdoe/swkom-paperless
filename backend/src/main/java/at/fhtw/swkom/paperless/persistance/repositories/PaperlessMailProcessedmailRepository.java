package at.fhtw.swkom.paperless.persistance.repositories;

import at.fhtw.swkom.paperless.persistance.entities.PaperlessMailProcessedmail;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PaperlessMailProcessedmailRepository implements JpaRepository<PaperlessMailProcessedmail, Long> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends PaperlessMailProcessedmail> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PaperlessMailProcessedmail> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PaperlessMailProcessedmail getOne(Long aLong) {
        return null;
    }

    @Override
    public PaperlessMailProcessedmail getById(Long aLong) {
        return null;
    }

    @Override
    public PaperlessMailProcessedmail getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PaperlessMailProcessedmail> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PaperlessMailProcessedmail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PaperlessMailProcessedmail> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PaperlessMailProcessedmail> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<PaperlessMailProcessedmail> findAll() {
        return null;
    }

    @Override
    public List<PaperlessMailProcessedmail> findAllById(Iterable<Long> longs) {
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
    public void delete(PaperlessMailProcessedmail entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PaperlessMailProcessedmail> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<PaperlessMailProcessedmail> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PaperlessMailProcessedmail> findAll(Pageable pageable) {
        return null;
    }
}
