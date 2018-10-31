victim(mr_boddy).
victim(cook).
victim(motorist).
victim(police_officer).
victim(yvette).
victim(singing_telegram).

suspect(professor_plum).
suspect(mrs_peacock).
suspect(mrs_white).
suspect(miss_scarlet).
suspect(colonel_mustard).
suspect(mr_green).
suspect(wadsworth).

weapon(wrench).
weapon(candlestick).
weapon(lead_pipe).
weapon(knife).
weapon(revolver).
weapon(rope).

room(hall).
room(kitchen).
room(lounge).
room(library).
room(billiard_room).

murder(mr_boddy,candlestick,hall).
murder(cook,knife,kitchen).
murder(motorist,wrench,lounge).
murder(police_officer,lead_pipe,library).
murder(singing_telegram,revolver,hall).
murder(yvette,rope,billiard_room).

% Suspect X has motive to kill Victim Y
motive(professor_plum, singing_telegram).
motive(mrs_peacock, cook).
motive(mrs_white, yvette).
motive(miss_scarlet, police_officer).
motive(colonel_mustard, yvette).
motive(wadsworth, singing_telegram).
motive(miss_scarlet, yvette).
motive(colonel_mustard, motorist). 
motive(professor_plum, mr_boddy).
motive(mrs_peacock, mr_boddy).
motive(mrs_white, mr_boddy).
motive(miss_scarlet, mr_boddy).
motive(colonel_mustard, mr_boddy).
motive(mr_green, mr_boddy).

%Suspect X doesn't use weapon Y
doesnt_use(colonel_mustard, rope).
doesnt_use(mrs_peacock, candlestick).
doesnt_use(professor_plum, revolver).

%Suspect X wasn't in room Y
wasnt_in(miss_scarlet, billiard_room).
wasnt_in(professor_plum, kitchen).
wasnt_in(colonel_mustard, hall).
wasnt_in(miss_scarlet, hall).

%Suspect X has alibi for victim Y
alibi(mrs_white, mr_boddy).
alibi(mr_green, mr_boddy).
alibi(mr_green, cook).
alibi(mr_green, motorist).
alibi(mr_green, police_officer).
alibi(mr_green, yvette).
alibi(mr_green, singing_telegram).
alibi(miss_scarlet, mr_boddy).
alibi(miss_scarlet, singing_telegram).

%Rules
accuse(S,V) :- murder(V,W,R), victim(V), weapon(W), room(R), suspect(S), motive(S,V), not(doesnt_use(S,W)), not(wasnt_in(S,R)), not(alibi(S,V)).

%Answers
%Professor Plum kills Mr. Boddy.
%Mrs. Peacock kills the cook.
%Colonel Mustard kills the motorist.
%Miss Scarlet kills the police officer.
%Mrs. White kills Yvette.
%Wadsworth kills the singing telegram. 

