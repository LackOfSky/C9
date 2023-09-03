package cloud.nine.C9.Repository;

import cloud.nine.C9.Model.SongData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongDataRepository extends JpaRepository<SongData, Long> {
}
