myappend([], L2, L2).
myappend([H|T1], L2, [H|T2]) :- myappend(T1, L2, T2).

myreverse([], []).
myreverse([H|T], L) :- myreverse(T, RT), append(RT, [H], L).


add_nums([], 0).
add_nums([H|T], Sum) :-
  add_nums(T, S),
  Sum is H + S.


qsort([], []).
qsort([Pivot|Tail], Sorted) :-
  divide(Pivot, Tail, Left, Right),
  qsort(Left, LSort),
  qsort(Right, RSort),
  append(LSort, [Pivot|RSort], Sorted).

divide(P, [], [], []).
divide(P, [H|T], [H|L], R) :-
  P > H,
  divide(P, T, L, R).
divide(P, [H|T], L, [H|R]) :-
  P =< H,
  divide(P, T, L, R).

