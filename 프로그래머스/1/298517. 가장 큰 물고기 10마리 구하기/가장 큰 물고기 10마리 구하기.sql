select ID, LENGTH
from fish_info
where length is not null
order by length desc
limit 10;
