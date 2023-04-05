if (redis.call("exist",KEYS[1]))==1 then
    local state=tonumber(reids.call("get",KEYS[1]));
    if(state==1) then
        redis.call("incryby",KEYS[1],1);
    end;
    return 0;
end