%%%-------------------------------------------------------------------
%%% @author dedda
%%% @copyright (C) 2015, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 22. Sep 2015 11:13
%%%-------------------------------------------------------------------
-module(libido_test).
-author("dedda").

%% API
-export([add_test/0]).

add_test() ->
  X = libido:add(2, 3),
  5 = X,
  ok.