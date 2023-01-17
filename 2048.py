import numpy as np

def flatten(xs):
    result = []
    if isinstance(xs, (list, tuple)):
        for x in xs:
            result.extend(flatten(x))
    else:
        result.append(xs)
    return result

def reduce_list(my_list, idx=0):
    max = len(my_list)
    if idx+1<max:
        new_list = my_list[:idx]
        if my_list[idx]==my_list[idx+1]:
            new_list.append(my_list[idx]+my_list[idx+1])
            new_list.append(my_list[idx+2:])
        else:
            new_list = my_list
        new_list = flatten(new_list)
        return reduce_list(new_list, idx+1)
    else:
        return my_list

def main():
    num_lines = 4
    grid = []
    move = None
    while num_lines >= 0:
        if num_lines==0:
            move = str(input())
            break
        grid.append([int(number) for number in input().split()])
        num_lines -= 1
    move_map = {'0':-1, '1':-1, '2':1, '3':1}
    this_move = move_map[move]
    if move=='0' or move=='2':
        for row in grid:
            rev_row = row[::-1] # easier to reverse row when considering sliding to the right
            rev_row = [i for i in rev_row if i != 0] # will pad rows with 0s later before re-reversing them
            reduced = reduce_list(rev_row)
    
if __name__ == "__main__":
   main()
