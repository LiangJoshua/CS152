
# Available opcodes for our VM
PUSH_OP = /PUSH (\d+)/ # pushes a number (its argument) on to the stack.
PRINT_OP = /PRINT/ # pops the top number off of the stack and prints it
ADD_OP = /ADD/ # pops the top two elements off the stack, adds them, and puts the result back on to the stack
SUB_OP = /SUB/ # pops the top two elements off the stack, subtracts them, and ...
MUL_OP = /MUL/ # pops the top two elements off the stack, multiplies them, and ...

class VirtualMachine
  def initialize
    @stack = []
  end
  def exec(bytecode_file)
    File.open(bytecode_file, 'r') do |file|
      file.each_line do |ln|
        case ln
        when PUSH_OP
          @stack.push(ln.sub(PUSH_OP, '\1').to_i)
        when PRINT_OP
          v = @stack.pop
          puts v
        #
        # YOUR CODE HERE -- Add extra 'when' cases to handle
        # additional operations.
        #
        else
          raise "Unrecognized command: '#{ln}'"
        end
      end
    end
  end
end

if ARGV.length < 1
  puts "Usage: ruby vm.rb <bytecode file>"
  exit 1
end

source = ARGV[0]

vm = VirtualMachine.new
vm.exec(source)


