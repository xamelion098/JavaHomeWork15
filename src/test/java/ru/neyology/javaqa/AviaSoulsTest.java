package ru.neyology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("VLG", "MSK", 10_000, 15, 18);
    Ticket ticket2 = new Ticket("VLG", "SPB", 7_000, 18, 21);
    Ticket ticket3 = new Ticket("VLG", "SOCHI", 14_000, 13, 16);

    Ticket ticket4 = new Ticket("VLG", "MSK", 14_000, 12, 14);
    Ticket ticket5 = new Ticket("VLG", "KAZAN", 12_000, 14, 16);
    Ticket ticket6 = new Ticket("VLG", "TUR", 20_000, 15, 20);
    Ticket ticket7 = new Ticket("VLG", "MSK", 9_000, 21, 22);
    Ticket ticket8 = new Ticket("VLG", "BDV", 20_000, 15, 20);

    @Test
    public void compareToTest() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        assertTrue(ticket1.compareTo(ticket2) > 0);
        assertTrue(ticket2.compareTo(ticket3) < 0);
        assertTrue(ticket3.compareTo(ticket1) > 0);
        assertTrue(ticket4.compareTo(ticket3) == 0);
    }

    @Test
    public void sortPriceSeveralTest() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("VLG", "MSK");
        Ticket[] expected = {ticket7, ticket1, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortPriceZeroTest() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("VLG", "UFA");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortPriceOneTest() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("VLG", "KAZAN");
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortBySeveralTest() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.searchAndSortBy("VLG", "MSK", comparator);
        Ticket[] expected = {ticket7, ticket4, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByOneTest() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.searchAndSortBy("VLG", "SOCHI", comparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByZeroTest() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.searchAndSortBy("VLG", "UFA", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}