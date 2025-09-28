package com.app.boot.gst.repositories;

import com.app.boot.gst.entities.LineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemsRepo extends JpaRepository<LineItems, Long> {
}
