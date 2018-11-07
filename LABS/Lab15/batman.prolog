
villain(joker).
villain(penguin).
villain(catwoman).
villain(scarecrow).
villain(bane).

kills_people(joker).
kills_people(penguin).
kills_people(bane).

power(scarecrow, fear).
power(bane,venom).

% Rules
scary(V) :- villain(V), kills_people(V).
scary(V) :- villain(V), power(V,_).

% ?- findall(V, scary(V), R).
% R = [joker, penguin, bane, scarecrow, bane].
% 
% ?- setof(V, scary(V), R).  
% R = [bane, joker, penguin, scarecrow].

% What if we did not have setof?
find_scary(ScarySet) :-
  findall(V, scary(V), ListOfScaries),
  get_unique(ListOfScaries,ScarySet),
  !. % Green cut

get_unique([],[]).
get_unique([H|Tail], Set) :-
  get_unique(Tail, TailSet),
  \+ member(H, TailSet),
  Set = [H|TailSet].
get_unique([H|Tail], Set) :-
  get_unique(Tail, TailSet),
  member(H, TailSet),
  Set = TailSet.


