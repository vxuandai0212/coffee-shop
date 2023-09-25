package com.shop.coffee.repository;

import com.shop.coffee.pojo.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  default List<Object[]> getOrderList(EntityManager em) {
    Query query = em.createNativeQuery(
            "select od.quantity as itemQuantity, u.name as customerName,\n" +
              "o.queue_id as queueId, o.created_at as createdAt, o.updated_at as updatedAt,\n" +
              "o.status as status, si.price as itemPrice, c.name as itemCategory, i.name as itemName,\n" +
              "o.id as orderId, od.id as orderDetailId\n" +
              "from order_detail od\n" +
              "inner join orders o on o.id = od.order_id \n" +
              "inner join shop_item si on si.id = od.shop_item_id \n" +
              "inner join items i on i.id = si.item_id \n" +
              "inner join categories c on c.id = i.category_id \n" +
              "inner join queues q on q.id = o.queue_id\n" +
              "inner join shops s on s.id  = q.shop_id \n" +
              "inner join users u on u.id = o.customer_id");

    return query.getResultList();
  }
}
