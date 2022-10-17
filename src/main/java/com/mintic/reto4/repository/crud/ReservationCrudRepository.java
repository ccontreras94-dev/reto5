package com.mintic.reto4.repository.crud;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mintic.reto4.model.Message;
import com.mintic.reto4.model.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    //select client_id, count(*) as total from reservation   group by client_id order by total DESC;
    @Query("SELECT c.client,COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT (c.client) DESC")
    public List<Object[]>getTopClients();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date d1,Date d2);

    public List<Reservation> findAllByStatus(String sts);
}
