package com.app.boot.gst.repositories;

import com.app.boot.gst.entities.LineItemsResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemsResponseRepo extends JpaRepository<LineItemsResponse, Long> {
}
