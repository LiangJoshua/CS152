
%Airports
airport(aus, "Austin-Bergstrom International").
airport(ewr, "Newark Liberty International").
airport(lax, "Los Angeles International").
airport(phl, "Philadelphia International").
airport(sfo, "San Francisco International").
airport(sjc, "Norman Y. Mineta San Jose International").

% From, To, DepartTime, ArriveTime, Price
flight(sfo, lax, 8:00, 9:20, 86.31).
flight(sfo, lax, 12:40, 14:00, 89.42).
flight(sfo, lax, 20:30, 21:50, 69.97).
flight(lax, sfo, 9:10, 10:25, 90.32).
flight(lax, sfo, 15:55, 17:10, 82.05).
flight(lax, sjc, 9:55, 11:05, 151.19).
flight(lax, sjc, 18:05, 19:15, 149.80).
flight(sjc, lax, 9:50, 11:10, 162.00).
flight(sjc, lax, 15:31, 16:50, 205.06).
flight(sfo, aus, 6:05, 13:33, 399.20).
flight(aus, sfo, 7:00, 11:29, 399.20).
flight(aus, sfo, 12:44, 16:25, 399.20).
flight(lax, aus, 7:00, 16:00, 297.20).
flight(lax, aus, 14:30, 19:25, 297.20).
flight(aus, lax, 8:12, 9:44, 472.20).
flight(aus, lax, 12:44, 14:20, 472.20).
flight(sfo, phl, 8:20, 16:37, 890.71).
flight(phl, sfo, 6:00, 9:19, 787.47).
flight(phl, sfo, 16:24, 19:40, 787.47).
flight(aus, phl, 7:45, 11:56, 427.47).
flight(phl, aus, 17:14, 20:16, 427.47).
flight(aus, ewr, 6:29, 11:11, 240.15).
flight(aus, ewr, 13:19, 18:00, 240.15).
flight(ewr, aus, 9:00, 12:22, 240.15).
flight(ewr, aus, 19:15, 22:46, 240.15).
flight(lax, ewr, 8:30, 16:49, 292.47).
flight(lax, ewr, 12:50, 20:59, 292.47).
flight(ewr, lax, 9:05, 12:20, 292.47).
flight(ewr, lax, 5:25, 20:40, 292.47).
flight(phl, ewr, 9:55, 10:48, 415.96).
flight(phl, ewr, 14:40, 15:31, 415.96).
flight(ewr, phl, 6:59, 8:00, 415.96).
flight(ewr, phl, 11:35, 12:28, 415.96).
flight(ewr, phl, 14:29, 15:23, 415.96).
flight(sfo, ewr, 7:25, 15:56, 313.40).
flight(sfo, ewr, 14:50, 23:14, 313.40).
flight(ewr, sfo, 7:30, 10:55, 313.40).
flight(ewr, sfo, 10:30, 13:55, 313.40).
flight(ewr, sfo, 16:11, 19:40, 313.40).


% YOUR JOB: Complete the route rule
% Departing: 3 letter code of the airport the traveler is departing from.
% Arriving: 3 letter code of the airport the traveler is traveling to.
% Visited: Airports already visited previously in the trip.
% DepartureTime: Time leaving the departing airport.
% ArrivalTime: Time arriving at the final destination.
% Flights: List of the airports to visit, in order.
% TotalCost: Cost of all flights.
route(Departing, Arriving, Visited, DepartureTime, ArrivalTime, Flights, TotalCost) :-
  fail.


